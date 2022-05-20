package com.example.login.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login.R;
import com.example.login.model.CourseModel;
import com.example.login.model.GradesModel;
import com.example.login.model.StudentModel;
import com.example.login.net.courseService;
import com.example.login.net.gradeService;
import com.example.login.net.studentService;
import com.example.login.retrofit.RetroFitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewGPA extends AppCompatActivity {


    StudentModel student =  new StudentModel();

    int creditCount = 0;
    float obtCredits = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_gpa);

        EditText t1 = findViewById(R.id.GPAValue);
        EditText t2 = findViewById(R.id.fieldrankValue);
        EditText t3 = findViewById(R.id.batchrankValue);

        //use retrofit service
        RetroFitService retrofit = new RetroFitService();


        studentService stdapi = retrofit.getRetrofit().create(studentService.class);

        stdapi.getStudentbyId(MainActivity.s.getId())
                .enqueue(new Callback<StudentModel>() {
                    @Override
                    public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
                        student = response.body();
                        t1.setText(""+student.getGpa());
                    }

                    @Override
                    public void onFailure(Call<StudentModel> call, Throwable t) {

                    }
                });

        stdapi.getStudentbyId(MainActivity.s.getId())
                .enqueue(new Callback<StudentModel>() {
                    @Override
                    public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
                        student = response.body();
                        t2.setText(""+ student.getFieldrank());

                    }

                    @Override
                    public void onFailure(Call<StudentModel> call, Throwable t) {

                    }
                });

        stdapi.getStudentbyId(MainActivity.s.getId())
                .enqueue(new Callback<StudentModel>() {
                    @Override
                    public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
                        student = response.body();
                        t3.setText(""+ student.getBatchrank());

                    }

                    @Override
                    public void onFailure(Call<StudentModel> call, Throwable t) {

                    }
                });

    }
}





