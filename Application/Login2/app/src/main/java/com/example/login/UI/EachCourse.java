package com.example.login.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.R;
import com.example.login.model.CourseModel;
import com.example.login.model.StudentModel;
import com.example.login.net.courseService;
import com.example.login.retrofit.RetroFitService;
import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EachCourse extends AppCompatActivity {

    int cID = coursePageStudent.courseIdToPass;
    CourseModel course = new CourseModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each_course);

        EditText e1 = findViewById(R.id.Quiz);
        EditText e2 = findViewById(R.id.Assignment);
        EditText e3 = findViewById(R.id.project);
        EditText e4 = findViewById(R.id.expected);
        TextView t1 = findViewById(R.id.calculate);
        MaterialButton m1 = findViewById(R.id.see);

        //use retrofit service
        RetroFitService retrofit = new RetroFitService();

        //create instance of employee api object
        courseService courseapi =retrofit.getRetrofit().create(courseService.class);

//        m1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                courseapi.getSingleCourse(cID)
//                        .enqueue(new Callback<CourseModel>() {
//                            @Override
//                            public void onResponse(Call<CourseModel> call, Response<CourseModel> response) {
//
//                                if(!response.isSuccessful()){
//                                    Toast.makeText(EachCourse.this, response.toString(), Toast.LENGTH_SHORT).show();
//                                }else {
//                                    course=(CourseModel) response.body();
//
//                                    int quizPercentage = course.getQuizp();
//                                    int assignmetPercentage = course.getAssignmentp();
//                                    int projectPercentage = course.getProjectp();
//                                    int finalPercentage = 100 - quizPercentage - assignmetPercentage - projectPercentage;
//
//                                    int quiz = Integer.parseInt(String.valueOf(e1.getText()));
//                                    int assignment = Integer.parseInt(String.valueOf(e2.getText()));
//                                    int project = Integer.parseInt(String.valueOf(e3.getText()));
//
//                                    int totalDone = (quiz*(quizPercentage/100)) + (assignment*(assignment/100)) + (project*(projectPercentage/100));
//
//
//                                    int expMark = (80 - totalDone) * (100/finalPercentage);
//                                    t1.setText(expMark);
//                                }
//
//                            }
//
//                            @Override
//                            public void onFailure(Call<List<CourseModel>> call, Throwable t) {
//
//                            }
//                        });
//
//            }
//        });

        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseapi.getSingleCourse(cID)
                        .enqueue(new Callback<CourseModel>() {
                            @Override
                            public void onResponse(Call<CourseModel> call, Response<CourseModel> response) {

                                if(!response.isSuccessful()){
                                    Toast.makeText(EachCourse.this, response.toString(), Toast.LENGTH_SHORT).show();
                                }else{
                                    course = (CourseModel) response.body();

                                    int quizPercentage = course.getQuizp();
                                    int assignmetPercentage = course.getAssignmentp();
                                    int projectPercentage = course.getProjectp();
                                    int finalPercentage = 100 - quizPercentage - assignmetPercentage - projectPercentage;

                                    int quiz = Integer.parseInt(String.valueOf(e1.getText()));
                                    int assignment = Integer.parseInt(String.valueOf(e2.getText()));
                                    int project = Integer.parseInt(String.valueOf(e3.getText()));

                                    int totalDone = (quiz*(quizPercentage/100)) + (assignment*(assignment/100)) + (project*(projectPercentage/100));


                                    int expMark = (80 - totalDone) * (100/finalPercentage);
                                    t1.setText("Aim for "+expMark+"% at the final exam");
                                }

                            }

                            @Override
                            public void onFailure(Call<CourseModel> call, Throwable t) {

                            }
                        });
            }
        });




//        courseapi.getcourses(semID)
//                .enqueue(new Callback<List<CourseModel>>() {
//                    @Override
//                    public void onResponse(Call<List<CourseModel>> call, Response<List<CourseModel>> response) {
//
//                        if(!response.isSuccessful()){
//                            Toast.makeText(EachCourse.this, response.toString(), Toast.LENGTH_SHORT).show();
//                        }else {
//                            course=(CourseModel) response.body();
//
//                            int quizPercentage = course.getQuizp();
//                            int assignmetPercentage = course.getAssignmentp();
//                            int projectPercentage = course.getProjectp();
//                            int finalPercentage = 100 - quizPercentage - assignmetPercentage - projectPercentage;
//
//                            int quiz = Integer.parseInt(String.valueOf(e1.getText()));
//                            int assignment = Integer.parseInt(String.valueOf(e2.getText()));
//                            int project = Integer.parseInt(String.valueOf(e3.getText()));
//
//                            int expMark = (80- ((quiz*(quizPercentage/100)) + (assignment*(assignment/100) + (project*(projectPercentage/100))) * (100/finalPercentage);
//                            t1.setText("Mark that should be obtained at the final is "+expMark+"%");
//                        }
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<CourseModel>> call, Throwable t) {
//
//                    }
//                });
    }
}