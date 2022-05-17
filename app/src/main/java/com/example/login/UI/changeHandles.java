package com.example.login.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.login.R;
import com.google.android.material.button.MaterialButton;

public class changeHandles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_handles);

        MaterialButton changeAdminBtn = findViewById(R.id.changeBatchAdmin);
        changeAdminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewAdmin();
            }
        });

    }

    public void openNewAdmin(){
        Intent intent = new Intent(this, newAdmin.class);
        startActivity(intent);
    }
}