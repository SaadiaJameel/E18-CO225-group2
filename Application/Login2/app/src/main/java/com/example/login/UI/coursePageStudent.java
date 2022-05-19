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

import java.util.List;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page_student);

        int semID = SemesterAllStudent.semNumToPass;

        TextView txt = findViewById(R.id.txt);
        txt.setText("Semester "+SemesterAllStudent.semNumToPass);
        ImageButton imageButton = findViewById(R.id.refresh1);
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openeachCourse();
//            }
//        });

        //use retrofit service
        RetroFitService retrofit = new RetroFitService();

        //create instance of employee api object
        courseService courseapi =retrofit.getRetrofit().create(courseService.class);

        if(length != 0){
            for(int i = 0 ; i <length ; ++i){
                layout.removeView(btns[i]);
            }
        }

//        courseapi.getcourses(semID)
//                .enqueue(new Callback<List<CourseModel>>() {
//                    @Override
//                    public void onResponse(Call<List<CourseModel>> call, Response<List<CourseModel>> response) {
//
//                        List<CourseModel> myheroList = response.body();
//                        length = myheroList.size();
//                        btns = new Button[length];
//
//                        for (int i = 0 ;  i < length ;  i++) {
////                                    semNumber = myheroList.get(i).getSemnumber();
//                            //semNumber = myheroList.get(i).getId();
//                            //String courseName = "Semester " + myheroList.get(i).getSemnumber();;
//                            String courseName = myheroList.get(i).getCoursecode() + ": "+ myheroList.get(i).getCoursename() ;
//                            refreshPage(semNumberStr, i);
//                        }
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<SemesterModel>> call, Throwable t) {
//
//                    }
//                });
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
                            courseID = myheroList.get(i).getId();
                            String courseName = myheroList.get(i).getCoursecode() + ": "+ myheroList.get(i).getCoursename() ;
                            refreshPage(courseName, i);
                        }

                    }

                    @Override
                    public void onFailure(Call<List<CourseModel>> call, Throwable t) {

                    }
                });


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
    @Override
    public void onClick(View v) {
        Button button = (Button) findViewById(v.getId());
        courseIdToPass = button.getId();
        openeachCourse();

    }
    public void openeachCourse(){
        Intent intent = new Intent(this, EachCourse.class);
        startActivity(intent);
    }

    public void refreshPage(String text, int index){
        layout = (LinearLayout) findViewById(R.id.rootlayout1);
        newbtn = new Button(this);
        newbtn.setId((int) courseID);
        newbtn.setText(text);
        layout.addView(newbtn);
        btns[index] = newbtn;
        //sems[index] = semNumber;
        newbtn.setOnClickListener(this);
//        newbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openCoursePage();
//            }
//        });
    }
}