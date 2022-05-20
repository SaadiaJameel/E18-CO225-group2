package com.example.login.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.login.R;
import com.example.login.model.GradesModel;
import com.example.login.net.gradeService;
import com.example.login.retrofit.RetroFitService;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewExpectedGrades extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_expected_grades);

        MaterialButton m1 = findViewById(R.id.enter);
        EditText t1 = findViewById(R.id.expValue);

        ListView ll = findViewById(R.id.lview);
        List<GradesModel> notFinalized = new ArrayList<>();

        //use retrofit service
        RetroFitService retrofit = new RetroFitService();

        //create instance of employee api object
        gradeService gradesapi =retrofit.getRetrofit().create(gradeService.class);

        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gradesapi.getgrades(MainActivity.s.getId())
                        .enqueue(new Callback<List<GradesModel>>() {
                            @Override
                            public void onResponse(Call<List<GradesModel>> call, Response<List<GradesModel>> response) {
                                int finalizedCredits = 0;
                                int toBeCredits = 0;
                                int totalCredits = 0;

                                List<GradesModel> g = response.body();

                                for (int j = 0 ; j < g.size() ; j++){
                                    if(!(g.get(j).isIsfinalized())){
                                        notFinalized.add(g.get(j));
                                        toBeCredits += g.get(j).getCredits();
                                    }else{
                                        finalizedCredits += g.get(j).getCredits();
                                    }
                                }
                                totalCredits = toBeCredits + finalizedCredits;
                                //int gp  = (int) ((totalCredits * Integer.parseInt(String.valueOf(t1))) - (finalizedCredits * MainActivity.s.getGpa())) / (totalCredits - finalizedCredits);
                                String[] pass = new String[notFinalized.size()];
                                for(int k = 0 ;  k < pass.length ; ++k){
                                    pass[k] = notFinalized.get(k).getCoursecode()+"  " +notFinalized.get(k).getCoursename()+ ":  ";
                                }
                                ll.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, pass ));

                            }

                            @Override
                            public void onFailure(Call<List<GradesModel>> call, Throwable t) {

                            }
                        });
            }
        });

    }
}