package com.example.login.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.login.R;
import com.google.android.material.button.MaterialButton;

public class AddSemester extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_semester);

        ImageButton addCoursebtn = findViewById(R.id.imageButton2);

        MaterialButton addSem = findViewById(R.id.addSem);
        addSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddSemester.this, "New semester added successfully", Toast.LENGTH_SHORT).show();
                openAllSemester();
            }
        });

        addCoursebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openAddCourse();

            }
        });

    }

    public void openAddCourse(){
        Intent intent = new Intent(this, AddCourse.class);
        startActivity(intent);
    }

    public void openAllSemester(){
        Intent intent = new Intent(this, SemesterAllStudent.class);
        startActivity(intent);
    }
}