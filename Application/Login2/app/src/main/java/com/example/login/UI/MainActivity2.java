package com.example.login.UI;

//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.login.R;
//import com.google.android.material.button.MaterialButton;
//
//public class MainActivity2 extends AppCompatActivity {
//
//    MaterialButton regButton;
//    TextView displayText;
//    String p1, p2;
//
//
//    TextView password1;
//    TextView password2;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//
//        password1 = (TextView) findViewById(R.id.psword);
//
//        password2 = (TextView) findViewById(R.id.confirmpsword);
//
//        //displayText = (TextView) findViewById(R.id.displaymessage);
//        regButton = (MaterialButton) findViewById(R.id.register);
//
//        regButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                p1 = password1.getText().toString();
//                p2 = password2.getText().toString();
//
//                if(p1.equals(p2)){
//
//                    Toast.makeText(MainActivity2.this, "REGISTRATION SUCCESSFUL", Toast.LENGTH_SHORT).show();
//
//                    backtoMain();
//
//
//                }else{
//                    Toast.makeText(MainActivity2.this, "PASSWORDS DO NOT MATCH", Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//        });
//    }
//
//    public void backtoMain(){
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//    }
//}

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.R;
import com.example.login.model.StudentModel;
import com.example.login.net.studentService;
import com.example.login.retrofit.RetroFitService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initializecomponents();

    }

    private void initializecomponents() {

        EditText username = findViewById(R.id.uname);          //username object
        EditText password1 =  findViewById(R.id.psword);               //password
        EditText password2 =  findViewById(R.id.confirmpsword);        //confirm password
        //TextView displayText = findViewById(R.id.displaymessage);     //text to display
        MaterialButton regButton = findViewById(R.id.register);       //button

        //use retrofit service
        RetroFitService retrofit = new RetroFitService();

        //create instance of employee api object
        studentService studentapi=retrofit.getRetrofit().create(studentService.class);

        //when registration button is pressed
        regButton.setOnClickListener(view ->{
            //get values in text boxes
            String name = String.valueOf(username.getText());
            String p1 = String.valueOf(password1.getText());
            String p2 = String.valueOf(password2.getText());

            //mae student object
            StudentModel student = new StudentModel();
            student.setUsername(name);
            student.setPassword(p1);

            if(p1.equals(p2)){

                //give api student object to save
                studentapi.signup(student)
                        .enqueue(new Callback<StudentModel>() {
                            @Override
                            public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
                                Toast.makeText(MainActivity2.this, "Save succesfull!", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<StudentModel> call, Throwable t) {
                                Toast.makeText(MainActivity2.this, "Save failed", Toast.LENGTH_SHORT).show();

                                //error message
                                Logger.getLogger(MainActivity2.class.getName()).log(Level.SEVERE, "Error occured",t);
                            }
                        });
                backtoMain();


            }else {
                Toast.makeText(MainActivity2.this, "PASSWORDS DO NOT MATCH", Toast.LENGTH_SHORT).show();
            }

        });
    }


    public void backtoMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

