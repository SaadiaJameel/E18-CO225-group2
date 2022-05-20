package com.example.login.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.login.R;
import com.example.login.UI.AddSemester;
import com.google.android.material.button.MaterialButton;

public class SettingsMain extends AppCompatActivity {

    MaterialButton addSemesterbtn;
    MaterialButton handlesChange;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_main);

        addSemesterbtn = (MaterialButton) findViewById(R.id.Semesters);
        addSemesterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddsemester();
            }
        });

        handlesChange = (MaterialButton) findViewById(R.id.Handle);
        handlesChange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openChangeHandles();
            }
        });
    }

    public void openAddsemester(){
        Intent intent = new Intent(this, AddSemester.class);
        startActivity(intent);
    }

    public void openChangeHandles(){
        Intent intent = new Intent(this, changeHandles.class);
        startActivity(intent);
    }
}