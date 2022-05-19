package com.example.login;

import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.login.databinding.ActivityExpectedGradeBinding;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.http.GET;

public class ExpectedGrade extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityExpectedGradeBinding binding;


    private class Course {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expected_grade);

        initializeComponent();
    }

    private void initializeComponent(){
        TextView inputexpectedGPA= findViewById(R.id.expected_gpa);
        Button buttonadd = findViewById(R.id.button_add);
        Button buttonchange = findViewById(R.id.button_change);
        Button buttoncalculate = findViewById(R.id.button_calculate);

        /*buttonadd.setOnClickListener(){
                float exgpa = float.valueOf(inputexpectedGPA.getText());

        };
        buttonchange.setOnClickListener();
        buttoncalculate.setOnClickListener();*/








        /*binding = ActivityExpectedGradeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_expected_grade);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    int totalNoOfCredits;
    int creditsNotYetReceivedGradesFor;
    int currentgpa;

    public void calculateExpectedGrade(int exgpa){
        float gpaToGet = exgpa*(totalNoOfCredits+creditsNotYetReceivedGradesFor)
                                  - (currentgpa*totalNoOfCredits);
        //List <String> neededGradesArray = new ArrayList<String>();
        Map <String, Integer> courseCredits = new HashMap<String, Integer>();
        Map <String, String> neededGrades = new HashMap<String, String>();

        float gpaForeachCredit = gpaToGet/creditsNotYetReceivedGradesFor;

        for (String key : neededGrades.keySet()){
            String ccourse = key;       //getting the course code
            for (String key1 : courseCredits.keySet()){
                int credits = courseCredits.get(ccourse);   //getting the no of credis fpr each course
                float gpaNeeded = credits * gpaForeachCredit;  //gpa needed
                String convertToGrade = getGrade(gpaNeeded); //converted to grade
                neededGrades.put(ccourse, convertToGrade);   //setting grade in map

            }
        }


    //ToDo: return a hashmap containing coursecode and needed grades and display as a table


    }

    public String getGrade(double gpaNeeded){
        gpaNeeded = gpaNeeded/0.3;
        String gradeN;
        switch ((int) Math.round(gpaNeeded)){
            case 13: gradeN = "A";
            case 12: gradeN = "A-";
            case 11: gradeN = "B+";
            case 10: gradeN = "B";
            case 9: gradeN = "B-";
            case 8: gradeN = "C+";
            case 7: gradeN = "C";
            default:gradeN = "C";
        }

        return gradeN;

    }



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_expected_grade);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}