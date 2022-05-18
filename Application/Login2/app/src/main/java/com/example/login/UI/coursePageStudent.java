//package com.example.login.UI;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//import com.example.login.R;
//
//public class coursePageStudent extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_course_page_student);
//    }
//}

package com.example.login.UI;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.login.R;

public class coursePageStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page_student);

        TextView txt = findViewById(R.id.txt);
        txt.setText("Semester "+SemesterAllStudent.semNumToPass);
    }
}