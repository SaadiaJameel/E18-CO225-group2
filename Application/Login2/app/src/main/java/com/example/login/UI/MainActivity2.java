package com.example.login.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.R;
import com.example.login.model.StudentModel;
import com.example.login.net.studentService;
import com.example.login.retrofit.RetroFitService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Drop down boxes to enter crucial details that will be used to group students
    private Spinner spinnerUniversity;
    private Spinner spinnerFaculty;
    private Spinner spinnerBatch;
    private Spinner spinnerField;


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
        EditText email = findViewById(R.id.mail);
        MaterialButton regButton = findViewById(R.id.register);       //button
        CheckBox check = findViewById(R.id.Rep);

        spinnerUniversity = findViewById(R.id.University);
        spinnerFaculty = findViewById(R.id.Faculty);
        spinnerBatch= findViewById(R.id.Batch);
        spinnerField = findViewById(R.id.Field);

        String[] universities  = getResources().getStringArray(R.array.universities);
        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, universities);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUniversity.setAdapter(adapter1);

        String[] faculties  = getResources().getStringArray(R.array.Faculty);
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, faculties);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFaculty.setAdapter(adapter2);

        String[] batch  = getResources().getStringArray(R.array.Batch);
        ArrayAdapter adapter3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, batch);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBatch.setAdapter(adapter3);

        String[] fields  = getResources().getStringArray(R.array.Field);
        ArrayAdapter adapter4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, fields);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerField.setAdapter(adapter4);


        //use retrofit service
        RetroFitService retrofit = new RetroFitService();

        //create instance of employee api object
        studentService studentapi=retrofit.getRetrofit().create(studentService.class);

        //when registration button is pressed add the new student to the database
        regButton.setOnClickListener(view ->{
            //get values in text boxes
            String name = String.valueOf(username.getText());
            String p1 = String.valueOf(password1.getText());
            String p2 = String.valueOf(password2.getText());
            boolean isrep = (check).isChecked();
            String mail = String.valueOf(email.getText());
            String uni = String.valueOf(spinnerUniversity.getSelectedItem());
            String fac = String.valueOf(spinnerFaculty.getSelectedItem());
            String Batch = String.valueOf(spinnerBatch.getSelectedItem());
            String Field = String.valueOf(spinnerField.getSelectedItem());


            //make student object
            StudentModel student = new StudentModel();
            student.setUsername(name);
            student.setPassword(p1);
            student.setIsrep(isrep);
            student.setEmail(mail);
            student.setUni(uni);
            student.setFaculty(fac);
            student.setBatch(Batch);
            student.setField(Field);

            //Check whether the entered passwords match
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

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    public void backtoMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent){

    }
}

