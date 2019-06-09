package com.example.android.sportquiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Create object of class Questions.
    Questions que = new Questions();

    //Variables declarations.
    private int score = 0;

    @BindView(R.id.Score_TextView)
    TextView scoreDisplay;
    @BindView(R.id.Choice1_RadioButton)
    RadioButton rb1;
    @BindView(R.id.Choice2_RadioButton)
    RadioButton rb2;
    @BindView(R.id.Choice3_RadioButton)
    RadioButton rb3;
    @BindView(R.id.Choice4_RadioButton)
    RadioButton rb4;
    @BindView(R.id.Next_Button)
    Button next;
    @BindView(R.id.Answer_EditText)
    EditText answerEditText;
    @BindView(R.id.Question_TextView)
    TextView Question;
    @BindView(R.id.RadioGroup)
    RadioGroup rg;
    @BindView(R.id.QueNumber_TextView)
    TextView queNumber;
    @BindView(R.id.LineraLayout_CheckBox)
    LinearLayout liCheckBox;
    @BindView(R.id.Choice1_CheckBox)
    CheckBox ch1;
    @BindView(R.id.Choice2_CheckBox)
    CheckBox ch2;
    @BindView(R.id.Choice3_CheckBox)
    CheckBox ch3;
    @BindView(R.id.Choice4_CheckBox)
    CheckBox ch4;

    //This variable gets requested question from mQuestions array in Questions class.
    private int mQuestionNumber = 0;
    private int QueScore10 = 0;
    //This variable gets right answer from mAnswer array in Questions class.
    private String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //Displays the questions and chocies on screen at first time only.
        updateQuestion();
    }

    @OnClick({R.id.Choice1_RadioButton,
            R.id.Choice2_RadioButton,
            R.id.Choice3_RadioButton,
            R.id.Choice4_RadioButton,
            R.id.Next_Button,
            R.id.Answer_EditText,
            R.id.Choice1_CheckBox,
            R.id.Choice2_CheckBox,
            R.id.Choice3_CheckBox,
            R.id.Choice4_CheckBox})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //This RadioButton 1 called when the user click on it.
            case R.id.Choice1_RadioButton:

                if (rb1.getText().equals(answer)) {
                    rb1.setBackgroundColor(getResources().getColor(R.color.True));
                    displayScore();

                    //Turn off clicks on all chocies.
                    setAllClickable();
                } else {
                    rb1.setBackgroundColor(getResources().getColor(R.color.False));

                    //Turn off clicks on all chocies.
                    setAllClickable();
                }
                break;

            //This RadioButton 2 called when the user click on it.
            case R.id.Choice2_RadioButton:

                if (rb2.getText().equals(answer)) {
                    rb2.setBackgroundColor(getResources().getColor(R.color.True));
                    displayScore();

                    //Turn off clicks on all chocies.
                    setAllClickable();
                } else {
                    rb2.setBackgroundColor(getResources().getColor(R.color.False));

                    //Turn off clicks on all chocies.
                    setAllClickable();
                }
                break;

            //This RadioButton 3 called when the user click on it.
            case R.id.Choice3_RadioButton:

                if (rb3.getText().equals(answer)) {
                    rb3.setBackgroundColor(getResources().getColor(R.color.True));
                    displayScore();

                    //Turn off clicks on all chocies.
                    setAllClickable();
                } else {
                    rb3.setBackgroundColor(getResources().getColor(R.color.False));

                    //Turn off clicks on all chocies.
                    setAllClickable();
                }
                break;

            //This RadioButton 4 called when the user click on it.
            case R.id.Choice4_RadioButton:

                if (rb4.getText().equals(answer)) {
                    rb4.setBackgroundColor(getResources().getColor(R.color.True));
                    displayScore();

                    //Turn off clicks on all chocies.
                    setAllClickable();
                } else {
                    rb4.setBackgroundColor(getResources().getColor(R.color.False));

                    //Turn off clicks on all chocies.
                    setAllClickable();
                }

                break;

            //This next button displays next question.
            case R.id.Next_Button:

                if (mQuestionNumber == que.mQuestions.length) {

                    //Displays the ResultActivity.
                    Intent i = new Intent(MainActivity.this, ResultActivity.class);
                    i.putExtra("Score", score + " / 10");
                    startActivity(i);
                } else {
                    updateQuestion();

                    //Set the RadioButtons clickable to ON.
                    rb1.setClickable(true);
                    rb2.setClickable(true);
                    rb3.setClickable(true);
                    rb4.setClickable(true);
                }
                break;

            //Check if the user enter the right answer on EditText or not.
            case R.id.Answer_EditText:

                //Convert EditText to String and store it in  String variable.
                String value = answerEditText.getText().toString();

                //Convert String variable to Integer and store it in Integer variable.
                int finalValue = Integer.parseInt(value);

                //Check if the answer = 5, displays the score and if not update question only without update the score.
                if (finalValue == 5) {
                    displayScore();
                }
                break;

            case R.id.Choice1_CheckBox:
            case R.id.Choice2_CheckBox:
            case R.id.Choice3_CheckBox:
            case R.id.Choice4_CheckBox:

                //Set one onClickListner for all checkboxes.
                ch1.setOnClickListener(this);
                ch2.setOnClickListener(this);
                ch3.setOnClickListener(this);
                ch4.setOnClickListener(this);

                break;
        }
    }

    //This method update questions.
    private void updateQuestion() {

        //Check if current index of question is greater than one, switch EditText with RadioButtons.
        if (mQuestionNumber > 1) {
            rg.setVisibility(View.VISIBLE);
            answerEditText.setVisibility(View.GONE);
        }

        //Check if current index of question equal to one, switch RadioButtons with EditText.
        if (mQuestionNumber == 1) {
            rg.setVisibility(View.GONE);
            answerEditText.setVisibility(View.VISIBLE);
            Question.setText(que.mQuestions[mQuestionNumber]);
        }

        //Check if current index of question equal to nine or the last question, switch RadioButtons with CheckBoxes.
        if (mQuestionNumber == 9) {
            QueScore10++;
            queNumber.setText("Que: " + QueScore10 + " / 10");
            next.setText("Finish");
            rg.setVisibility(View.GONE);
            liCheckBox.setVisibility(View.VISIBLE);

            //Displays the question.
            Question.setText(que.mQuestions[mQuestionNumber]);

            //Displays four choices of the question.
            ch1.setText(que.mChoices[mQuestionNumber][0]);
            ch2.setText(que.mChoices[mQuestionNumber][1]);
            ch3.setText(que.mChoices[mQuestionNumber][2]);
            ch4.setText(que.mChoices[mQuestionNumber][3]);
            answer = que.mAnswer[mQuestionNumber];
            setMultiAttributesCheckBoxes();
            mQuestionNumber++;

        } else {
            QueScore10++;
            queNumber.setText("Que: " + QueScore10 + " / 10");
            resetColors();
            setMultiAttributes();
            uncheckSelection();
            Question.setText(que.mQuestions[mQuestionNumber]);
            rb1.setText(que.mChoices[mQuestionNumber][0]);
            rb2.setText(que.mChoices[mQuestionNumber][1]);
            rb3.setText(que.mChoices[mQuestionNumber][2]);
            rb4.setText(que.mChoices[mQuestionNumber][3]);
            answer = que.mAnswer[mQuestionNumber];
            mQuestionNumber++;
        }
    }

    //This method reset colors for all views to default color.
    private void resetColors() {
        rb1.setBackgroundResource(R.color.Buttons);
        rb2.setBackgroundResource(R.color.Buttons);
        rb3.setBackgroundResource(R.color.Buttons);
        rb4.setBackgroundResource(R.color.Buttons);
    }

    //This method displays the score.
    private void displayScore() {
        score++;
        scoreDisplay.setText("Score : " + score);
    }

    //This method set multi attributes of views and question.
    private void setMultiAttributes() {
        Question.setTextSize(25);
        rb1.setTextSize(20);
        rb2.setTextSize(20);
        rb3.setTextSize(20);
        rb4.setTextSize(20);
        rb1.setAllCaps(false);
        rb2.setAllCaps(false);
        rb3.setAllCaps(false);
        rb4.setAllCaps(false);
        rb1.setTypeface(Typeface.MONOSPACE);
        rb2.setTypeface(Typeface.MONOSPACE);
        rb3.setTypeface(Typeface.MONOSPACE);
        rb4.setTypeface(Typeface.MONOSPACE);
    }

    //This method set multi attributes of CheckBoxes and question.
    private void setMultiAttributesCheckBoxes() {
        Question.setTextSize(25);
        ch1.setTextSize(20);
        ch2.setTextSize(20);
        ch3.setTextSize(20);
        ch4.setTextSize(20);
        ch1.setAllCaps(false);
        ch2.setAllCaps(false);
        ch3.setAllCaps(false);
        ch4.setAllCaps(false);
        ch1.setTypeface(Typeface.MONOSPACE);
        ch2.setTypeface(Typeface.MONOSPACE);
        ch3.setTypeface(Typeface.MONOSPACE);
        ch4.setTypeface(Typeface.MONOSPACE);
        ch1.setBackgroundResource(R.color.Buttons);
        ch2.setBackgroundResource(R.color.Buttons);
        ch3.setBackgroundResource(R.color.Buttons);
        ch4.setBackgroundResource(R.color.Buttons);
    }

    //Uncheck the selections of RadioButtons.
    private void uncheckSelection() {
        rg.clearCheck();
    }

    //Turn off clicks on all choices when the user answers the question.
    private void setAllClickable() {
        rb1.setClickable(false);
        rb2.setClickable(false);
        rb3.setClickable(false);
        rb4.setClickable(false);
    }

    //Check if the user enter right answers or not.
    @Override
    public void onClick(View view) {
        if (ch1.isChecked() && !ch2.isChecked() && ch3.isChecked() && ch4.isChecked()) {
            score++;
        }
    }
}