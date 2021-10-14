package com.example.triviaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.triviaapp.data.AnswerListAsyncResponce;
import com.example.triviaapp.data.QuestionBank;
import com.example.triviaapp.model.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button trueBut,falseBut;
    ImageButton next,prev;
    TextView display,counter,Result,Scoree;
    private  int currentQuestionIndex=0;
    private List<Question>questionList;
    private int ScoreCounter=0;
    private Score score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score=new Score();

        trueBut=findViewById(R.id.Truebutton);
        falseBut=findViewById(R.id.Falsebutton);
        next=findViewById(R.id.nextButton);
        prev=findViewById(R.id.PrevButton);
        display=findViewById(R.id.Question_textview);
        counter=findViewById(R.id.counter);
        Result=findViewById(R.id.result);
        Scoree=findViewById(R.id.score);


        trueBut.setOnClickListener(this);
        falseBut.setOnClickListener(this);
        next.setOnClickListener(this);
        prev.setOnClickListener(this);
        display.setOnClickListener(this);
        counter.setOnClickListener(this);
        Result.setOnClickListener(this);



        questionList= new QuestionBank().getquestion(new AnswerListAsyncResponce() {
            @Override
            public void processFinished(ArrayList<Question> questionArrayList) {
           display.setText(questionArrayList.get(currentQuestionIndex).getAnswer());

          counter.setText(currentQuestionIndex+" / "+questionArrayList.size());
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.PrevButton:
                if (currentQuestionIndex>0){
                    currentQuestionIndex=(currentQuestionIndex-1)%questionList.size();
                    updateQuestion();
                    Result.setText("");
                }
            break;
            case R.id.nextButton:
                currentQuestionIndex=(currentQuestionIndex+1)%questionList.size();
                Result.setText("");
                updateQuestion();
            break;
            case R.id.Truebutton:
                 checkAnswar(true);
                 updateQuestion();
                break;
            case R.id.Falsebutton:
                checkAnswar(false);
                updateQuestion();
              //  Score.setText(""+-10);
                break;
        }



    }

    private void checkAnswar(boolean userChooseCorrect) {
      boolean answerIsTrue=questionList.get(currentQuestionIndex).isAnswerTrue();
   int toastMessageId=0;
   if (userChooseCorrect==answerIsTrue){
       fadeView();
       addPoint();
       toastMessageId=R.string.correct_answar;
       Result.setTextColor(getResources().getColor(R.color.green));




   }else {
       shakeAnimation();
       toastMessageId=R.string.wrong_answar;
       dePoint();
       Result.setTextColor(getResources().getColor(R.color.red));
   }
    Result.setText(toastMessageId);

    }

    public void addPoint(){
        ScoreCounter +=10;
        score.setScore(ScoreCounter);
      // Scoree.setText(score.getScore());
       // Toast.makeText(MainActivity.this,score.getScore(),Toast.LENGTH_SHORT).show();
       // Log.d("SCORE", "dePoint: "+score.getScore());
        Scoree.setText(String.valueOf("Score: "+score.getScore()));
    }
    public void dePoint(){
        ScoreCounter -=10;
        score.setScore(ScoreCounter);
      /**  if (ScoreCounter>0){
            score.setScore(ScoreCounter);
        }else {
            ScoreCounter=0;
            score.setScore(ScoreCounter);
            Log.d("SCORE", "dePoint: "+score.getScore());
        }*/
        Scoree.setText(String.valueOf("Score: "+score.getScore()));
       // Toast.makeText(MainActivity.this,score.getScore(),Toast.LENGTH_SHORT).show();

    }

    private void updateQuestion() {
        String question=questionList.get(currentQuestionIndex).getAnswer();
       display.setText(question);
       counter.setText(currentQuestionIndex+" / "+questionList.size());
    }
    private void fadeView(){
        CardView cardView=findViewById(R.id.cardView);
        AlphaAnimation alphaAnimation=new AlphaAnimation(1.0f,0.0f);
        alphaAnimation.setDuration(350);
        alphaAnimation.setRepeatCount(1);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        cardView.setAnimation(alphaAnimation);

        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
               cardView.setCardBackgroundColor(Color.GREEN);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
               cardView.setCardBackgroundColor(Color.WHITE );
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    public  void  shakeAnimation(){
        Animation shake= AnimationUtils.loadAnimation(MainActivity.this,R.anim.shaking_animation);
       final CardView cardView=findViewById(R.id.cardView);
         cardView.setAnimation(shake);


         shake.setAnimationListener(new Animation.AnimationListener() {
             @Override
             public void onAnimationStart(Animation animation) {
                 cardView.setCardBackgroundColor(Color.RED);
             }

             @Override
             public void onAnimationEnd(Animation animation) {
               cardView.setCardBackgroundColor(Color.WHITE);
             }

             @Override
             public void onAnimationRepeat(Animation animation) {

             }
         });
    }


}