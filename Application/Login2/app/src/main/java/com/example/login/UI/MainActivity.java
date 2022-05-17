package com.example.login.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.R;
import com.example.login.model.StudentModel;
import com.example.login.net.studentService;
import com.example.login.retrofit.RetroFitService;
import com.google.android.material.button.MaterialButton;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    String uname, pswd;

    TextView username;
    TextView password;

    MaterialButton signin;
    MaterialButton signupbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);

        signin = (MaterialButton) findViewById(R.id.signinbtn);
        signupbtn = (MaterialButton) findViewById(R.id.signupbtn);

        //use retrofit service
        RetroFitService retrofit = new RetroFitService();

        //create instance of employee api object
        studentService studentapi=retrofit.getRetrofit().create(studentService.class);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uname = username.getText().toString();
                pswd = password.getText().toString();

                studentapi.getStudent(uname)
                        .enqueue(new Callback<StudentModel>() {
                            @Override
                            public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {

                                String s = response.body().getin;

                                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<StudentModel> call, Throwable t) {

                            }
                        });


            }
        });

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }

    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void openSettings(){
        Intent intent = new Intent(this, SemesterAllStudent.class);
        startActivity(intent);
    }


}