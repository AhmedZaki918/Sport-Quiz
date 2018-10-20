package com.example.android.sportquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {


    TextView finalScore;
    Button restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        finalScore = findViewById(R.id.finalScore);
        restart = findViewById(R.id.restart);


      String receive = getIntent().getStringExtra("Score");
        finalScore.setText(receive);


        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
            }
        });
    }
}
