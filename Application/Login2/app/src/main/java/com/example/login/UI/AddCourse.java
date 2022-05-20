//package com.example.login.UI;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.EditText;
//import android.widget.LinearLayout;
//import android.widget.Spinner;
//import android.widget.Toast;
//
//import com.example.login.R;
//import com.example.login.UI.AddSemester;
//import com.example.login.model.CourseModel;
//import com.example.login.model.StudentModel;
//import com.example.login.net.courseService;
//import com.example.login.net.studentService;
//import com.example.login.retrofit.RetroFitService;
//import com.google.android.material.button.MaterialButton;
//
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class AddCourse extends AppCompatActivity {
//
//    MaterialButton addCourse;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_course);
//
//        initializecomponents();
//
//    }
//
//    private void initializecomponents() {
//
//        EditText ccode = findViewById(R.id.CourseCode);          //username object
//        EditText cName =  findViewById(R.id.CourseName);               //password
//        EditText ccredits =  findViewById(R.id.Credits);        //confirm password
//        EditText QuizP = findViewById(R.id.QuizP);
//        EditText AssP = findViewById(R.id.AssP);
//        EditText ProjectP = findViewById(R.id.ProjP);
//        EditText FinalP = findViewById(R.id.FinalP);
//
//
//
//        //TextView displayText = findViewById(R.id.displaymessage);     //text to display
//        MaterialButton addCourse = findViewById(R.id.courseAdd);       //button
//
//
//        //use retrofit service
//        RetroFitService retrofit = new RetroFitService();
//
//        //create instance of employee api object
//        courseService courseapi=retrofit.getRetrofit().create(courseService.class);
//
//        //when registration button is pressed
//        addCourse.setOnClickListener(view ->{
//            //get values in text boxes
//            String code = String.valueOf(ccode.getText());
//            String name = String.valueOf(cName.getText());
//            int credits = Integer.parseInt(String.valueOf(ccredits.getText()));
//            int Quiz = Integer.parseInt(String.valueOf(QuizP.getText()));
//            int Ass = Integer.parseInt(String.valueOf(AssP.getText()));
//            int Project = Integer.parseInt(String.valueOf(ProjectP.getText()));
//            //int Final = Integer.parseInt(String.valueOf(FinalP.getText()));
//
//
//            //mae student object
//            CourseModel course = new CourseModel();
//            course.setCoursecode(code);
//            course.setCoursename(name);
//            course.setCredits(credits);
//            course.setQuizp(Quiz);
//            course.setAssignmentp(Ass);
//            course.setProjectp(Project);
//
//            courseapi.addcourse(course)
//                    .enqueue(new Callback<CourseModel>() {
//                        @Override
//                        public void onResponse(Call<CourseModel> call, Response<CourseModel> response) {
//                            Toast.makeText(AddCourse.this, "New Course Added", Toast.LENGTH_SHORT).show();
//                            openAddSemester();
//                        }
//
//                        @Override
//                        public void onFailure(Call<CourseModel> call, Throwable t) {
//                            Toast.makeText(AddCourse.this, "Course Adding Failed", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//        });
//    }
//
//
//    public void openAddSemester(){
//        Intent intent = new Intent(this, AddSemester.class);
//        startActivity(intent);
//    }
//
//
//}

package com.example.login.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.login.R;
import com.example.login.UI.AddSemester;
import com.example.login.model.CourseModel;
import com.example.login.model.StudentModel;
import com.example.login.net.courseService;
import com.example.login.net.studentService;
import com.example.login.retrofit.RetroFitService;
import com.google.android.material.button.MaterialButton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCourse extends AppCompatActivity {

    MaterialButton addCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        initializecomponents();

    }

    private void initializecomponents() {


        //Declare all input sources in the UI
        EditText ccode = findViewById(R.id.CourseCode);          //username object
        EditText cName =  findViewById(R.id.CourseName);               //password
        EditText ccredits =  findViewById(R.id.Credits);        //confirm password
        EditText QuizP = findViewById(R.id.QuizP);
        EditText AssP = findViewById(R.id.AssP);
        EditText ProjectP = findViewById(R.id.ProjP);
        EditText FinalP = findViewById(R.id.FinalP);

        MaterialButton addCourse = findViewById(R.id.courseAdd);       //button
        MaterialButton addAllcourses = findViewById(R.id.addAllcourses);


        //use retrofit service
        RetroFitService retrofit = new RetroFitService();

        //create instance of employee api object
        courseService courseapi=retrofit.getRetrofit().create(courseService.class);

        //when Add Course button is pressed add a new course entry to the database
        addCourse.setOnClickListener(view ->{
            //get values in text boxes
            String code = String.valueOf(ccode.getText());
            String name = String.valueOf(cName.getText());
            int credits = Integer.parseInt(String.valueOf(ccredits.getText()));
            int Quiz = Integer.parseInt(String.valueOf(QuizP.getText()));
            int Ass = Integer.parseInt(String.valueOf(AssP.getText()));
            int Project = Integer.parseInt(String.valueOf(ProjectP.getText()));

            //make course object
            CourseModel course = new CourseModel();
            course.setCoursecode(code);
            course.setCoursename(name);
            course.setCredits(credits);
            course.setQuizp(Quiz);
            course.setAssignmentp(Ass);
            course.setProjectp(Project);
            course.setSemid(AddSemester.semi);
            course.setFieldgroup(MainActivity.s.getFieldgroup());

            //Pass the new course to the database via the Internet
            courseapi.addcourse(course)
                    .enqueue(new Callback<CourseModel>() {
                        @Override
                        public void onResponse(Call<CourseModel> call, Response<CourseModel> response) {
                            Toast.makeText(AddCourse.this, "New Course Added", Toast.LENGTH_SHORT).show();
                            refresh();
                        }

                        @Override
                        public void onFailure(Call<CourseModel> call, Throwable t) {
                            Toast.makeText(AddCourse.this, "Course Adding Failed", Toast.LENGTH_SHORT).show();
                        }
                    });
        });

        //When all courses are added, move to another activity
        addAllcourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSemesterAll();
            }
        });
    }

    //Refresh method
    public void refresh(){
        Intent intent = new Intent(this, AddCourse.class);
        startActivity(intent);
    }

    //New activity method
    public void openSemesterAll(){
        Intent intent = new Intent(this, SemesterAllStudent.class);
        startActivity(intent);
    }
}