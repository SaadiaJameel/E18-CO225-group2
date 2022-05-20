package com.example.login.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.R;
import com.example.login.model.CourseModel;
import com.example.login.model.GradesModel;
import com.example.login.model.StudentModel;
import com.example.login.net.courseService;
import com.example.login.net.gradeService;
import com.example.login.net.studentService;
import com.example.login.retrofit.RetroFitService;
import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EachCourse extends AppCompatActivity {

    int cID = coursePageStudent.courseIdToPass;
    CourseModel course = new CourseModel();
    StudentModel student =  new StudentModel();

    public static float GPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each_course);

        EditText e1 = findViewById(R.id.Quiz);
        EditText e2 = findViewById(R.id.Assignment);
        EditText e3 = findViewById(R.id.project);
        EditText e4 = findViewById(R.id.expected);
        EditText e5 = findViewById(R.id.Final);
        TextView t1 = findViewById(R.id.calculate);
        MaterialButton m1 = findViewById(R.id.see);
        MaterialButton m2 = findViewById(R.id.enterFinal);
        EditText e6  = findViewById(R.id.topicH);
        e6.setText(coursePageStudent.courseCode + ":  " + coursePageStudent.courseName);

        //use retrofit service
        RetroFitService retrofit = new RetroFitService();

        //create instance of employee api object
        courseService courseapi =retrofit.getRetrofit().create(courseService.class);


        //create instance of employee api object
        gradeService gradesapi =retrofit.getRetrofit().create(gradeService.class);

        studentService stdapi = retrofit.getRetrofit().create(studentService.class);

        //Calculating the final mark that should be obtained
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get the course object that the student is working on, to see the quiz, assignment, project percentages entered by the admin
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

                                    //Calculate and display the expected mark
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

        //When the user enters the confirmed final grade
        //Save the grade in the database
        //Update the student's GPA
        m2.setOnClickListener(view ->{

            long stdID = MainActivity.s.getId();
            String finalGrade = String.valueOf(e5.getText());
            boolean isFinal = true;

            GradesModel gradesmodel = new GradesModel();
            gradesmodel.setStudentid(stdID);
            gradesmodel.setFinalgrade(finalGrade);
            gradesmodel.setIsfinalized(isFinal);

            //Adding the grade
            gradesapi.putfinalgrade(MainActivity.s.getId(), cID, gradesmodel)
                    .enqueue(new Callback<GradesModel>() {
                        @Override
                        public void onResponse(Call<GradesModel> call, Response<GradesModel> response) {
                            Toast.makeText(EachCourse.this, "Grade added", Toast.LENGTH_SHORT).show();

                            MainActivity.s.setGpa(updateGPA(gradesapi));
                            //Update the student object with the latest GPA
                            stdapi.updatestudent(MainActivity.s.getId(), MainActivity.s)
                                    .enqueue(new Callback<StudentModel>() {
                                        @Override
                                        public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
                                            Toast.makeText(EachCourse.this, "GPA updated", Toast.LENGTH_SHORT).show();
                                        }

                                        @Override
                                        public void onFailure(Call<StudentModel> call, Throwable t) {

                                        }
                                    });
                            opencoursepageStudent();
                        }

                        @Override
                        public void onFailure(Call<GradesModel> call, Throwable t) {

                        }
                    });

        });

    }

    public  void opencoursepageStudent(){
        Intent intent = new Intent(this, coursePageStudent.class);
        startActivity(intent);
    }

    //Calculation to gte the GPA
    public float updateGPA(gradeService g){

        g.getgrades(MainActivity.s.getId())
                .enqueue(new Callback<List<GradesModel>>() {

                    @Override
                    public void onResponse(Call<List<GradesModel>> call, Response<List<GradesModel>> response) {
                        int creditCount = 0;
                        float obtCredits = 0;


                        List<GradesModel> grades = response.body();
                        for(int i = 0 ; i < grades.size() ; ++i){
                            float gpa = 0f;
                            if(grades.get(i).isIsfinalized()){
                                String grade = grades.get(i).getFinalgrade();

                                if (grade.equals("A+") || grade.equals("A")) {
                                    gpa = 4.0f;
                                } else if (grade.equals("A-")) {
                                    gpa = 3.7f;
                                } else if (grade.equals("B+")) {
                                    gpa = 3.3f;
                                } else if (grade.equals("B")) {
                                    gpa = 3.0f;
                                } else if (grade.equals("B-")) {
                                    gpa = 2.7f;
                                } else if (grade.equals("C+")) {
                                    gpa = 2.3f;
                                } else if (grade.equals("C")) {
                                    gpa = 2.0f;
                                } else if (grade.equals("C-")) {
                                    gpa = 1.7f;
                                } else if (grade.equals("D+")) {
                                    gpa = 1.3f;
                                } else if (grade.equals("D")) {
                                    gpa = 1.0f;
                                } else if (grade.equals("E")) {
                                    gpa = 0.0f;
                                }

                            }
                            CourseModel c = new CourseModel();
                            obtCredits +=  gpa * grades.get(i).getCredits();
                            creditCount += gpa * grades.get(i).getCredits();
                        }
                        EachCourse.GPA = obtCredits/creditCount;


                    }

                    @Override
                    public void onFailure(Call<List<GradesModel>> call, Throwable t) {

                    }

                });

        return EachCourse.GPA;
    }


}






