package com.example.login.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login.R;
import com.google.android.material.button.MaterialButton;

public class changeHandles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_handles);

        MaterialButton changeAdminBtn = findViewById(R.id.changeBatchAdmin);
        EditText t1 = findViewById(R.id.pswd);

        //Upon password entry
        changeAdminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check whether the password is correct and whether the logged in user is a rep
                if(MainActivity.s.isIsrep() && (MainActivity.s.getPassword().equals(String.valueOf(t1.getText())))) {
                    openNewAdmin();
                }else{
                    Toast.makeText(changeHandles.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void openNewAdmin(){
        Intent intent = new Intent(this, newAdmin.class);
        startActivity(intent);
    }
}