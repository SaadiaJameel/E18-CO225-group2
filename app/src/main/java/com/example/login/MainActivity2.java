package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    MaterialButton regButton;
    TextView displayText;
    String p1, p2;


    TextView password1;
    TextView password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        password1 = (TextView) findViewById(R.id.psword);

        password2 = (TextView) findViewById(R.id.confirmpsword);

        displayText = (TextView) findViewById(R.id.displaymessage);
        regButton = (MaterialButton) findViewById(R.id.register);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                p1 = password1.getText().toString();
                p2 = password2.getText().toString();

                if(p1.equals(p2)){
                    displayText.setText("Registration successful!");
                    final long PERIOD = 1000L; // Adjust to suit timing
                    long lastTime = System.currentTimeMillis() - PERIOD;

                    long thisTime = System.currentTimeMillis();
                    if((thisTime - lastTime) >= PERIOD){
                        backtoMain();
                    }

                }else{
                    displayText.setText("Passwords do not match.");
                }


            }
        });
    }

    public void backtoMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}