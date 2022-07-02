package com.example.testing12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final long START_TIME_IN_MILLIOne = 15000;
    private static final long START_TIME_IN_MILLITwo = 600000;
    private static final long START_TIME_IN_MILLIThree = 780000;
    private SwitchCompat switch1;
    private SwitchCompat switch2;
    private SwitchCompat switch3;
    TextView topText;

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliOne = START_TIME_IN_MILLIOne;
    private long timeLeftInMilliTwo = START_TIME_IN_MILLITwo;
    private long timeLeftInMilliThree = START_TIME_IN_MILLIThree;

    private TextView bottext;

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topText= findViewById(R.id.TextView);
        switch1= findViewById(R.id.switch1);
        switch2= findViewById(R.id.switch2);
        switch3= findViewById(R.id.switch3);
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(topText,"backgroundColor" , Color.BLUE, Color.GREEN);
        objectAnimator.setDuration(500);
        objectAnimator.setEvaluator(new ArgbEvaluator());
        objectAnimator.setRepeatMode(Animation.REVERSE);



        bottext=findViewById(R.id.botText);
        mp=MediaPlayer.create(this,R.raw.alarmmusic);

        switch3.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                startTimerThree();
                objectAnimator.start();
            }
            else{
                resetTimerThree();
            }
        });
        switch2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                startTimerTwo();
                objectAnimator.start();
            }
            else{
                resetTimerTwo();
            }
        });
        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                startTimerOne();
                objectAnimator.start();
            }
            else{
                resetTimerOne();
            }
        });
    }

    private void startTimerOne() {
        countDownTimer = new CountDownTimer(timeLeftInMilliOne, 1000) {
            @Override
            public void onTick(long milliUntilFinished) {
                timeLeftInMilliOne = milliUntilFinished;
                updateTimeRemainingTextOne();
            }
            @Override
            public void onFinish() {
                mp.start();
                timeLeftInMilliOne = START_TIME_IN_MILLIOne;
                countDownTimer.cancel();
                bottext.setText(R.string.zero);
                switch1.setChecked(false);

            }
        }.start();
    }
    private void resetTimerOne() {
        timeLeftInMilliOne = START_TIME_IN_MILLIOne;
        countDownTimer.cancel();
        bottext.setText(R.string.zero);
    }
    private void updateTimeRemainingTextOne(){
        int minutes= (int)(timeLeftInMilliOne /1000)/60;
        int seconds= (int)(timeLeftInMilliOne /1000)%60;
        String timeleftformatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        bottext.setText(timeleftformatted);
    }

    private void startTimerTwo() {
        countDownTimer = new CountDownTimer(timeLeftInMilliTwo, 1000) {
            @Override
            public void onTick(long milliUntilFinished) {
                timeLeftInMilliTwo = milliUntilFinished;
                updateTimeRemainingTextTwo();
            }
            @Override
            public void onFinish() {
                mp.start();
                timeLeftInMilliTwo = START_TIME_IN_MILLITwo;
                countDownTimer.cancel();
                bottext.setText(R.string.zero);
                switch2.setChecked(false);
            }
        }.start();
    }
    private void resetTimerTwo() {
        timeLeftInMilliTwo = START_TIME_IN_MILLITwo;
        countDownTimer.cancel();
        bottext.setText(R.string.zero);
    }
    private void updateTimeRemainingTextTwo(){
        int minutes= (int)(timeLeftInMilliTwo /1000)/60;
        int seconds= (int)(timeLeftInMilliTwo /1000)%60;
        String timeleftformatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        bottext.setText(timeleftformatted);
    }

    private void startTimerThree() {
        countDownTimer = new CountDownTimer(timeLeftInMilliThree, 1000) {
            @Override
            public void onTick(long milliUntilFinished) {
                timeLeftInMilliThree = milliUntilFinished;
                updateTimeRemainingTextThree();
            }
            @Override
            public void onFinish() {
                mp.start();
                timeLeftInMilliThree = START_TIME_IN_MILLIThree;
                countDownTimer.cancel();
                bottext.setText(R.string.zero);
                switch3.setChecked(false);
            }
        }.start();
    }
    private void resetTimerThree() {
        timeLeftInMilliThree = START_TIME_IN_MILLIThree;
        countDownTimer.cancel();
        bottext.setText(R.string.zero);
    }
    private void updateTimeRemainingTextThree(){
        int minutes= (int)(timeLeftInMilliThree /1000)/60;
        int seconds= (int)(timeLeftInMilliThree /1000)%60;
        String timeleftformatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        bottext.setText(timeleftformatted);
    }
    public void stopMusic(View view){
    mp.stop();
    }

}