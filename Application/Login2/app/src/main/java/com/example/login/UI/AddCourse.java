package com.example.login.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import com.example.login.R;

public class AddCourse extends AppCompatActivity {

    private Spinner spinnerQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        spinnerQuiz = findViewById(R.id.Quiz);

    }
}