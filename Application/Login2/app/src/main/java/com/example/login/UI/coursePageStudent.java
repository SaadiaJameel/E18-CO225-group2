package com.example.login.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageHelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.login.R;
import com.example.login.model.CourseModel;
import com.example.login.model.SemesterModel;
import com.example.login.net.addSemService;
import com.example.login.net.courseService;
import com.example.login.retrofit.RetroFitService;
import com.google.android.material.button.MaterialButton;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class coursePageStudent extends AppCompatActivity implements View.OnClickListener{

    Button newbtn;
    int length = 0;
    private LinearLayout layout;
    Button[] btns;
    long courseID;
    static int courseIdToPass;
    static String courseCode;
    static String courseName;

    //Store the attributes of the course object in a map
    HashMap<Integer, String> map1 = new HashMap<>();
    HashMap<Integer, String> map2 = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page_student);

        int semID = SemesterAllStudent.semIdClicked;

        //Display the heading using a static variable from semester all student
        TextView txt = findViewById(R.id.txt);
        txt.setText("Semester "+SemesterAllStudent.semNumToPass);
        MaterialButton imageButton = findViewById(R.id.refresh1);

        //use retrofit service
        RetroFitService retrofit = new RetroFitService();
        courseService courseapi =retrofit.getRetrofit().create(courseService.class);

        //Refresh the page
        if(length != 0){
            for(int i = 0 ; i <length ; ++i){
                layout.removeView(btns[i]);
            }
        }

        //Display all the courses of that semseter
        courseapi.getcourses(semID)
                .enqueue(new Callback<List<CourseModel>>() {
                    @Override
                    public void onResponse(Call<List<CourseModel>> call, Response<List<CourseModel>> response) {

                        List<CourseModel> myheroList = response.body();
                        length = myheroList.size();
                        btns = new Button[length];

                        for (int i = 0 ;  i < length ;  i++) {

                            courseID = myheroList.get(i).getId();
                            map1.put((int) courseID, myheroList.get(i).getCoursecode());
                            map2.put((int) courseID, myheroList.get(i).getCoursename());
                            String courseName = myheroList.get(i).getCoursecode() + ": "+ myheroList.get(i).getCoursename() ;
                            //Call the method to display dynamic buttons
                            refreshPage(courseName, i);
                        }

                    }

                    @Override
                    public void onFailure(Call<List<CourseModel>> call, Throwable t) {

                    }
                });

        //Do the above again when the refresh button is clicked
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(length != 0){
                    for(int i = 0 ; i <length ; ++i){
                        layout.removeView(btns[i]);
                    }
                }

                courseapi.getcourses(semID)
                        .enqueue(new Callback<List<CourseModel>>() {
                            @Override
                            public void onResponse(Call<List<CourseModel>> call, Response<List<CourseModel>> response) {

                                List<CourseModel> myheroList = response.body();
                                length = myheroList.size();
                                btns = new Button[length];

                                for (int i = 0 ;  i < length ;  i++) {
//                                    semNumber = myheroList.get(i).getSemnumber();
                                    //semNumber = myheroList.get(i).getId();
                                    //String courseName = "Semester " + myheroList.get(i).getSemnumber();;
                                    String courseName = myheroList.get(i).getCoursecode() + ": "+ myheroList.get(i).getCoursename() ;
                                    refreshPage(courseName, i);
                                }

                            }

                            @Override
                            public void onFailure(Call<List<CourseModel>> call, Throwable t) {

                            }
                        });

            }
        });




    }
    //When a dynamic button is clicked, obtain the relevant details of the clicked courseModel
    @Override
    public void onClick(View v) {
        Button button = (Button) findViewById(v.getId());
        courseIdToPass = button.getId();
        courseCode = map1.get(button.getId());
        courseName = map2.get(button.getId());
        openeachCourse();

    }
    public void openeachCourse(){
        Intent intent = new Intent(this, EachCourse.class);
        startActivity(intent);
    }

    //Method to add dynamic buttons
    public void refreshPage(String text, int index){
        layout = (LinearLayout) findViewById(R.id.rootlayout1);
        newbtn = new Button(this);
        newbtn.setId((int) courseID);
        newbtn.setText(text);
        layout.addView(newbtn);
        btns[index] = newbtn;
        newbtn.setOnClickListener(this);

    }
}