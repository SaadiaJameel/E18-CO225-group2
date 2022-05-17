package com.example.login.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import com.example.login.R;
import com.google.android.material.button.MaterialButton;

public class AddCourse extends AppCompatActivity {

    MaterialButton addCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        MaterialButton addCourse = findViewById(R.id.courseAdd);

        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddSemester();
            }
        });

    }

    public void openAddSemester(){
        Intent intent = new Intent(this, AddSemester.class);
        startActivity(intent);
    }
}