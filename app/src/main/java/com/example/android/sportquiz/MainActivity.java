package com.example.android.sportquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView Question;
    TextView scoreDisplay;
    int score = 0;

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button next;


    Questions que = new Questions();

    int mQuestionNumber = 0;
    String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Find locations of buttons.
        btn1 = findViewById(R.id.answer1);
        btn2 = findViewById(R.id.answer2);
        btn3 = findViewById(R.id.answer3);
        btn4 = findViewById(R.id.answer4);
        scoreDisplay = findViewById(R.id.Score);
        next = findViewById(R.id.next);


        Question = findViewById(R.id.Question);


        Question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateQuestion();
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (btn1.getText() == answer) {

                    btn1.setBackgroundColor(getResources().getColor(R.color.True));
                    displayScore();



                    if (mQuestionNumber == que.mQuestions.length) {

                        Intent i = new Intent(MainActivity.this, ResultActivity.class);
                        i.putExtra("Score", score + " / 5");
                        startActivity(i);
                    }


                } else {

                    btn1.setBackgroundColor(getResources().getColor(R.color.False));


                    if (mQuestionNumber == que.mQuestions.length) {

                        Intent i = new Intent(MainActivity.this, ResultActivity.class);
                        i.putExtra("Score", score + " / 5");
                        startActivity(i);
                    }

                    Intent i = new Intent(MainActivity.this, ResultActivity.class);
                    i.putExtra("Score", score + " / 5");
                    startActivity(i);


                }
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (btn2.getText() == answer) {

                    btn2.setBackgroundColor(getResources().getColor(R.color.True));
                    displayScore();



                    if (mQuestionNumber == que.mQuestions.length) {

                        Intent i = new Intent(MainActivity.this, ResultActivity.class);
                        i.putExtra("Score", score + " / 5");
                        startActivity(i);
                    }


                } else {


                    btn2.setBackgroundColor(getResources().getColor(R.color.False));


                    if (mQuestionNumber == que.mQuestions.length) {

                        Intent i = new Intent(MainActivity.this, ResultActivity.class);
                        i.putExtra("Score", score + " / 5");
                        startActivity(i);
                    }

                    Intent i = new Intent(MainActivity.this, ResultActivity.class);
                    i.putExtra("Score", score + " / 5");
                    startActivity(i);


                }
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (btn3.getText() == answer) {

                    btn3.setBackgroundColor(getResources().getColor(R.color.True));
                    displayScore();



                    if (mQuestionNumber == que.mQuestions.length) {

                        Intent i = new Intent(MainActivity.this, ResultActivity.class);
                        i.putExtra("Score", score + " / 5");
                        startActivity(i);
                    }


                } else {


                    btn3.setBackgroundColor(getResources().getColor(R.color.False));

                    if (mQuestionNumber == que.mQuestions.length) {

                        Intent i = new Intent(MainActivity.this, ResultActivity.class);
                        i.putExtra("Score", score + " / 5");
                        startActivity(i);
                    }

                    Intent i = new Intent(MainActivity.this, ResultActivity.class);
                    i.putExtra("Score", score + " / 5");
                    startActivity(i);


                }
            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (btn4.getText() == answer) {

                    btn4.setBackgroundColor(getResources().getColor(R.color.True));
                    displayScore();


                    if (mQuestionNumber == que.mQuestions.length) {

                        Intent i = new Intent(MainActivity.this, ResultActivity.class);
                        i.putExtra("Score", score + " / 5");
                        startActivity(i);
                    }


                } else {

                    btn4.setBackgroundColor(getResources().getColor(R.color.False));

                    if (mQuestionNumber == que.mQuestions.length) {

                        Intent i = new Intent(MainActivity.this, ResultActivity.class);
                        i.putExtra("Score", score + " / 5");
                        startActivity(i);
                    }

                    Intent i = new Intent(MainActivity.this, ResultActivity.class);
                    i.putExtra("Score",score + " / 5");
                    startActivity(i);


                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuestion();
                resetColors();
            }
        });


    }


    public void resetColors() {

        btn1.setBackgroundResource(R.color.Buttons);
        btn2.setBackgroundResource(R.color.Buttons);
        btn3.setBackgroundResource(R.color.Buttons);
        btn4.setBackgroundResource(R.color.Buttons);

    }

    public void updateQuestion() {

        setTextSize();
        Question.setText(que.mQuestions[mQuestionNumber]);
        btn1.setText(que.mChoices[mQuestionNumber][0]);
        btn2.setText(que.mChoices[mQuestionNumber][1]);
        btn3.setText(que.mChoices[mQuestionNumber][2]);
        btn4.setText(que.mChoices[mQuestionNumber][3]);
        answer = que.mAnswer[mQuestionNumber];
        mQuestionNumber++;

    }

    public void displayScore() {

        score++;
        scoreDisplay.setText("Score : " + score);

    }

    public void setTextSize() {

        Question.setTextSize(25);
        btn1.setTextSize(20);
        btn2.setTextSize(20);
        btn3.setTextSize(20);
        btn4.setTextSize(20);


    }
}

