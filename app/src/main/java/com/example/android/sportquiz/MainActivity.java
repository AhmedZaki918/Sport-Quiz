package com.example.android.sportquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Variables declarations.

    TextView Question;
    TextView scoreDisplay;

    int score = 0;

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button next;

    //Create object of class Questions.
    Questions que = new Questions();

    //This variable gets requested question from mQuestions array in Questions class.
    int mQuestionNumber = 0;

    //This variable gets right answer from mAnswer array in Questions class.
    String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find locations of views.
        btn1 = findViewById(R.id.Answer1_Button);
        btn2 = findViewById(R.id.Answer2_Button);
        btn3 = findViewById(R.id.Answer3_Button);
        btn4 = findViewById(R.id.Answer4_Button);
        scoreDisplay = findViewById(R.id.Score_TextView);
        next = findViewById(R.id.Next_Button);
        Question = findViewById(R.id.Question_TextView);

        //TextView displays first question only.
        Question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuestion();
            }
        });

        //This button A called when the user click on it.
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (btn1.getText() == answer) {

                    btn1.setBackgroundColor(getResources().getColor(R.color.True));
                    displayScore();

                    //Check if this the last question or not before update question.
                    if (mQuestionNumber == que.mQuestions.length) {

                        Intent i = new Intent(MainActivity.this, ResultActivity.class);
                        i.putExtra("Score", score + " / 10");
                        startActivity(i);
                    }


                } else {

                    btn1.setBackgroundColor(getResources().getColor(R.color.False));

                    //Check if this the last question or not before update question.
                    if (mQuestionNumber == que.mQuestions.length) {

                        Intent i = new Intent(MainActivity.this, ResultActivity.class);
                        i.putExtra("Score", score + " / 10");
                        startActivity(i);
                    }

                    Intent i = new Intent(MainActivity.this, ResultActivity.class);
                    i.putExtra("Score", score + " / 10");
                    startActivity(i);
                }
            }
        });

        //This button B called when the user click on it.
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (btn2.getText() == answer) {

                    btn2.setBackgroundColor(getResources().getColor(R.color.True));
                    displayScore();

                    //Check if this the last question or not before update question.
                    if (mQuestionNumber == que.mQuestions.length) {

                        Intent i = new Intent(MainActivity.this, ResultActivity.class);
                        i.putExtra("Score", score + " / 10");
                        startActivity(i);
                    }


                } else {

                    btn2.setBackgroundColor(getResources().getColor(R.color.False));

                    //Check if this the last question or not before update question.
                    if (mQuestionNumber == que.mQuestions.length) {

                        Intent i = new Intent(MainActivity.this, ResultActivity.class);
                        i.putExtra("Score", score + " / 10");
                        startActivity(i);
                    }

                    Intent i = new Intent(MainActivity.this, ResultActivity.class);
                    i.putExtra("Score", score + " / 10");
                    startActivity(i);
                }
            }
        });

        //This button C called when the user click on it.
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (btn3.getText() == answer) {
                    btn3.setBackgroundColor(getResources().getColor(R.color.True));
                    displayScore();

                    //Check if this the last question or not before update question.
                    if (mQuestionNumber == que.mQuestions.length) {

                        Intent i = new Intent(MainActivity.this, ResultActivity.class);
                        i.putExtra("Score", score + " / 10");
                        startActivity(i);
                    }

                } else {

                    btn3.setBackgroundColor(getResources().getColor(R.color.False));

                    //Check if this the last question or not before update question.
                    if (mQuestionNumber == que.mQuestions.length) {

                        Intent i = new Intent(MainActivity.this, ResultActivity.class);
                        i.putExtra("Score", score + " / 10");
                        startActivity(i);
                    }

                    Intent i = new Intent(MainActivity.this, ResultActivity.class);
                    i.putExtra("Score", score + " / 10");
                    startActivity(i);
                }
            }
        });

        //This button D called when the user click on it.
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (btn4.getText() == answer) {

                    btn4.setBackgroundColor(getResources().getColor(R.color.True));
                    displayScore();

                    //Check if this the last question or not before update question.
                    if (mQuestionNumber == que.mQuestions.length) {

                        Intent i = new Intent(MainActivity.this, ResultActivity.class);
                        i.putExtra("Score", score + " / 10");
                        startActivity(i);
                    }

                } else {

                    btn4.setBackgroundColor(getResources().getColor(R.color.False));
                    //Check if this the last question or not before update question.
                    if (mQuestionNumber == que.mQuestions.length) {

                        Intent i = new Intent(MainActivity.this, ResultActivity.class);
                        i.putExtra("Score", score + " / 10");
                        startActivity(i);
                    }

                    Intent i = new Intent(MainActivity.this, ResultActivity.class);
                    i.putExtra("Score", score + " / 10");
                    startActivity(i);
                }
            }
        });

        //This next button displays next question.
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuestion();
                resetColors();
            }
        });
    }

    //This method reset colors for all buttons to default color.
    public void resetColors() {

        btn1.setBackgroundResource(R.color.Buttons);
        btn2.setBackgroundResource(R.color.Buttons);
        btn3.setBackgroundResource(R.color.Buttons);
        btn4.setBackgroundResource(R.color.Buttons);
    }

    //This method update questions.
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

    //This method displays the score.
    public void displayScore() {

        score++;
        scoreDisplay.setText("Score : " + score);
    }

    //This method set text size of buttons and question.
    public void setTextSize() {

        Question.setTextSize(25);
        btn1.setTextSize(20);
        btn2.setTextSize(20);
        btn3.setTextSize(20);
        btn4.setTextSize(20);
    }
}