package com.example.login.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login.R;
import com.google.android.material.button.MaterialButton;

public class newAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_admin);

        MaterialButton logOutBtn = findViewById(R.id.LogOut);
        EditText reg1 = findViewById(R.id.regNum1);
        EditText reg2 = findViewById(R.id.regNum2);


        String regNum1 = String.valueOf(reg1.getText());
        String regNum2 = String.valueOf(reg2.getText());


        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(regNum1.equals(regNum2)) {
                    Toast.makeText(newAdmin.this, regNum2, Toast.LENGTH_SHORT).show();
                    backToMain();
                }else{
                    Toast.makeText(newAdmin.this, "User names do not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void backToMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}