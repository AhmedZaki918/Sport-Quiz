package com.example.android.sportquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    //Variables declarations.
    TextView finalScore;
    Button restart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Find locations of views.
        finalScore = findViewById(R.id.finalScore_TextView);
        restart = findViewById(R.id.Restart_Button);

        //Create string variable and store it the score from MainActivity.
        String receive = getIntent().getStringExtra("Score");

        //Set score on finalScore TextView.
        finalScore.setText(receive);
        Toast.makeText(ResultActivity.this, "You scored  " + receive, Toast.LENGTH_SHORT).show();

        //This button restart the quiz.
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
            }
        });
    }
}
