//package com.example.login.UI;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.constraintlayout.utils.widget.ImageFilterButton;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ImageButton;
//
//import com.example.login.R;
//
//public class SemesterAllStudent extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_semester_all_student);
//
//
//        ImageButton settingsBtn = findViewById(R.id.settings);
//        settingsBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                openSettingsMain();
//            }
//        });
//    }
//
//    public void openSettingsMain(){
//        Intent intent = new Intent(this, SettingsMain.class);
//        startActivity(intent);
//    }
//}

//package com.example.login.UI;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.Gravity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageButton;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//import android.widget.Toast;
//
//import com.example.login.R;
//import com.example.login.model.SemesterModel;
//import com.example.login.net.addSemService;
//import com.example.login.retrofit.RetroFitService;
//
//import java.util.List;
//import java.util.*;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class SemesterAllStudent extends AppCompatActivity implements View.OnClickListener{
//
//    static SemesterModel sem = new SemesterModel();
//
//    Button newbtn;
//    int length = 0;
//    long semNumber;
//    private LinearLayout layout;
//    Button[] btns;
//    //int [] sems;
//    static int semNumToPass;
//    static int semIdClicked;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_semester_all_student);
//
//        int field = MainActivity.s.getFieldgroup();
//
//        //use retrofit service
//        RetroFitService retrofit = new RetroFitService();
//
//        //create instance of employee api object
//        addSemService semapi =retrofit.getRetrofit().create(addSemService.class);
//
//        ImageButton refresh = findViewById(R.id.refresh);
//        refresh.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(length != 0){
//                    for(int i = 0 ; i <length ; ++i){
//                        layout.removeView(btns[i]);
//                    }
//                }
//
//                semapi.getSemesters(field)
//                        .enqueue(new Callback<List<SemesterModel>>() {
//                            @Override
//                            public void onResponse(Call<List<SemesterModel>> call, Response<List<SemesterModel>> response) {
//
//                                List<SemesterModel> myheroList = response.body();
//                                length = myheroList.size();
//                                btns = new Button[length];
//
//                                for (int i = 0 ;  i < length ;  i++) {
////                                    semNumber = myheroList.get(i).getSemnumber();
//                                    semNumber = myheroList.get(i).getId();
//                                    String semNumberStr = "Semester " + myheroList.get(i).getSemnumber();;
//                                    refreshPage(semNumberStr, i);
//                                }
//
//                            }
//
//                            @Override
//                            public void onFailure(Call<List<SemesterModel>> call, Throwable t) {
//
//                            }
//                        });
//            }
//        });
//
////        for(int j = 0 ; j < length ; ++j){
////            Button btn = findViewById(j);
////            btn.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////                    //openCoursePage();
////                    Toast.makeText(SemesterAllStudent.this, "Clicked", Toast.LENGTH_SHORT).show();
////                }
////            });
////        }
//
//        ImageButton settings = findViewById(R.id.settings);
//        settings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openSettingsMain();
//            }
//        });
//    }
//
//    public void refreshPage(String text, int index){
//        layout = (LinearLayout) findViewById(R.id.rootlayout);
//        newbtn = new Button(this);
//        newbtn.setId((int) semNumber);
//        newbtn.setText(text);
//        layout.addView(newbtn);
//        btns[index] = newbtn;
//        //sems[index] = semNumber;
//        newbtn.setOnClickListener(this);
////        newbtn.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                openCoursePage();
////            }
////        });
//    }
//
//    public void openSettingsMain(){
//        Intent intent = new Intent(this, SettingsMain.class);
//        startActivity(intent);
//    }
//
//    public void openCoursePage(){
//        Intent intent = new Intent(this, coursePageStudent.class);
//        startActivity(intent);
//    }
//
//    @Override
//    public void onClick(View v) {
//        Button button = (Button) findViewById(v.getId());
//        semNumToPass = button.getId();
//        openCoursePage();
//    }
//}


package com.example.login.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.login.R;
import com.example.login.model.SemesterModel;
import com.example.login.net.addSemService;
import com.example.login.retrofit.RetroFitService;

import java.util.List;
import java.util.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SemesterAllStudent extends AppCompatActivity implements View.OnClickListener{

    static SemesterModel sem = new SemesterModel();

    Button newbtn;
    int length = 0;
    long semNumber;
    private LinearLayout layout;
    Button[] btns;
    //int [] sems;
    static int semNumToPass;
    static int semIdClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_all_student);

        int field = MainActivity.s.getFieldgroup();

        //use retrofit service
        RetroFitService retrofit = new RetroFitService();

        //create instance of employee api object
        addSemService semapi =retrofit.getRetrofit().create(addSemService.class);

//        ImageButton refresh = findViewById(R.id.refresh);
//        refresh.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {

                if(length != 0){
                    for(int i = 0 ; i <length ; ++i){
                        layout.removeView(btns[i]);
                    }
                }

                semapi.getSemesters(field)
                        .enqueue(new Callback<List<SemesterModel>>() {
                            @Override
                            public void onResponse(Call<List<SemesterModel>> call, Response<List<SemesterModel>> response) {

                                List<SemesterModel> myheroList = response.body();
                                length = myheroList.size();
                                btns = new Button[length];

                                for (int i = 0 ;  i < length ;  i++) {
//                                    semNumber = myheroList.get(i).getSemnumber();
                                    semNumber = myheroList.get(i).getId();
                                    String semNumberStr = "Semester " + myheroList.get(i).getSemnumber();;
                                    refreshPage(semNumberStr, i);
                                }

                            }

                            @Override
                            public void onFailure(Call<List<SemesterModel>> call, Throwable t) {

                            }
                        });
//            }
//        });

            ImageButton refresh = findViewById(R.id.refresh);
            refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        if(length != 0){
            for(int i = 0 ; i <length ; ++i){
                layout.removeView(btns[i]);
            }
        }

        semapi.getSemesters(field)
                .enqueue(new Callback<List<SemesterModel>>() {
                    @Override
                    public void onResponse(Call<List<SemesterModel>> call, Response<List<SemesterModel>> response) {

                        List<SemesterModel> myheroList = response.body();
                        length = myheroList.size();
                        btns = new Button[length];

                        for (int i = 0 ;  i < length ;  i++) {
//                                    semNumber = myheroList.get(i).getSemnumber();
                            semNumber = myheroList.get(i).getId();
                            String semNumberStr = "Semester " + myheroList.get(i).getSemnumber();;
                            refreshPage(semNumberStr, i);
                        }

                    }

                    @Override
                    public void onFailure(Call<List<SemesterModel>> call, Throwable t) {

                    }
                });
            }
        });

//        for(int j = 0 ; j < length ; ++j){
//            Button btn = findViewById(j);
//            btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    //openCoursePage();
//                    Toast.makeText(SemesterAllStudent.this, "Clicked", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }

        ImageButton settings = findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsMain();
            }
        });
    }

    public void refreshPage(String text, int index){
        layout = (LinearLayout) findViewById(R.id.rootlayout);
        newbtn = new Button(this);
        newbtn.setId((int) semNumber);
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

    public void openSettingsMain(){
        Intent intent = new Intent(this, SettingsMain.class);
        startActivity(intent);
    }

    public void openCoursePage(){
        Intent intent = new Intent(this, coursePageStudent.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) findViewById(v.getId());
        semNumToPass = button.getId();
        openCoursePage();
    }
}


