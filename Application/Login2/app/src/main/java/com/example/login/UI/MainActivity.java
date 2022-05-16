package com.example.login.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.R;
import com.google.android.material.button.MaterialButton;

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

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uname = username.getText().toString();
                pswd = password.getText().toString();

                if(uname.equals("admin") && pswd.equals("admin")){
                    Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
                }

            }
        });

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });
    }

    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void openSettings(){
        Intent intent = new Intent(this, SettingsMain.class);
        startActivity(intent);
    }


}