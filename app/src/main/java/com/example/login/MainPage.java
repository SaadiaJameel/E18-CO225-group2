package com.example.login;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.login.databinding.ActivityMainPageBinding;

public class MainPage extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainPageBinding binding;

    /*private class Course {
        String courseCode;
        String courseName;
        String grade;
        double valueForGrade;

        public String getCourseCode() {
            return courseCode;
        }

        public void setCourseCode(String courseCode) {
            this.courseCode = courseCode;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public void setValueForGrade(String grade) {
            switch (grade) {
                case "A+":
                    valueForGrade = 4;
                case "A":
                    valueForGrade = 4;
                case "A-":
                    valueForGrade = 3.7;
                case "B+":
                    valueForGrade = 3.3;
                case "B":
                    valueForGrade = 3;
                case "B-":
                    valueForGrade = 2.7;
                case "C+":
                    valueForGrade = 2.3;
                case "C":
                    valueForGrade = 2;
                default:
                    valueForGrade = 0;

            }
        }

        public double getValueForGrade() {
            return valueForGrade;
        }

    }


    public int getCurrentGPA(String[] array){

        float valueArray[];

        for (int i=0;i<array.length; i++){
            valueArray[i] = convertGradeToValue(array[i]);
        }

        for (int i;  )


    }*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_page);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_page);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}