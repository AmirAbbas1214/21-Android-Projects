package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button TrueButton;
    Button FalseButton;
    TextView questionTextView;
    Button NextButton;
    Button prev;
    TextView result;
    private int currentIndex=0;

    private Questions [] questionsBook=new Questions[]{
            new Questions(R.string.Q1,true),
            new Questions(R.string.Q2,false),
            new Questions(R.string.Q3,true),
            new Questions(R.string.Q4,false),
            new Questions(R.string.Q5,false),
            new Questions(R.string.Q6,true),




    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Questions questions=new Questions(R.string.Q1,true);
//
        TrueButton=findViewById(R.id.trueButton);
        FalseButton=findViewById(R.id.falseButton);
        questionTextView=findViewById(R.id.ShowAnswer);
        NextButton=findViewById(R.id.next);
        result=findViewById(R.id.Result);
        prev=findViewById(R.id.pre);

        TrueButton.setOnClickListener(this);
        FalseButton.setOnClickListener(this);
        NextButton.setOnClickListener(this);
        prev.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.falseButton:
               checkAnswar(false);
                break;

            case R.id.trueButton:
               checkAnswar(true);
                break;

            case R.id.next:
               // Toast.makeText(MainActivity.this,"Next",Toast.LENGTH_SHORT).show();
                currentIndex=(currentIndex+1) % questionsBook.length;
                //questionTextView.setText(questionsBook[currentIndex].AnswarId);
                UpdateQuestion();
                result.setText("");
                break;
            case R.id.pre:
                currentIndex=(currentIndex-1)%questionsBook.length;
                UpdateQuestion();
                result.setText("");


        }

    }
    public void UpdateQuestion(){
        questionTextView.setText(questionsBook[currentIndex].AnswarId);

    }

   public void checkAnswar(boolean userChooseCorrect){
        boolean AnswarIsTrue=questionsBook[currentIndex].getAnswarTrue();
      int tostMessageId;


      if (userChooseCorrect ==AnswarIsTrue) {

          tostMessageId=R.string.TrueC;
          result.setTextColor(getResources().getColor(R.color.green));

      }else {
          tostMessageId=R.string.FalseW;
          result.setTextColor(getResources().getColor(R.color.red));

      }
    // Toast.makeText(MainActivity.this,tostMessageId,Toast.LENGTH_SHORT).show();
      result.setText(tostMessageId);
      }
    }