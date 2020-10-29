package com.example.stopwatchapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

public class StopWatchAct extends AppCompatActivity {

    Button btnstart, btnstop;
    ImageView icanchor;
    Animation roundingalone;
    Chronometer timehere;
    public boolean isVisible= false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnstart= findViewById(R.id.btnstart);
        btnstop= findViewById(R.id.btnstop);
        icanchor= findViewById(R.id.icanchor);
        timehere= findViewById(R.id.timehere);

        roundingalone= AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        btnstart.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Log.d("TAG", "onClick: start1111");

                                                Log.d("TAG", "onClick: start1122");

                                                AlphaAnimation fadeOutAnimation = new AlphaAnimation(1, 0);
                                                fadeOutAnimation.setDuration(300);
                                                fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {
                                                    @Override
                                                    public void onAnimationEnd(Animation animation) {
                                                        btnstop.setAlpha(1f);
                                                        btnstart.setAlpha(0f);

                                                    }

                                                    @Override
                                                    public void onAnimationRepeat(Animation animation) {
                                                    }

                                                    @Override
                                                    public void onAnimationStart(Animation animation) {
                                                        Log.d("TAG", "onClick: start1133");


                                                        icanchor.startAnimation(roundingalone);
                                                        timehere.setBase(SystemClock.elapsedRealtime());
                                                        timehere.start();
                                                    }
                                                });
                                                btnstart.startAnimation(fadeOutAnimation);
//                                            }

                                        }
                                    });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", "onClick: start1111");

//                if (isVisible) {
                    AlphaAnimation fadeOutAnimation = new AlphaAnimation(1, 0);
                    fadeOutAnimation.setDuration(300);
//                    fadeOutAnimation.setFillAfter(true);
                    fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationEnd(Animation animation) {
//                            btnstart.setVisibility(View.VISIBLE);
                            btnstart.setAlpha(1f);
                            btnstop.setAlpha(0f);
//                            isVisible = false;
                            Log.d("testt","fhdfhfhfd");

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override
                        public void onAnimationStart(Animation animation) {
                            Log.d("TAG", "onClick: start1133");

//                            btnstop.setVisibility(View.VISIBLE);


                            icanchor.clearAnimation();
                            Log.d("TAG", "onClick: stop1122");

                            timehere.stop();
                            timehere.setText("00:00");
                        }
                    });
                    btnstop.startAnimation(fadeOutAnimation);


//                }
            }
        });

        Typeface MMedium= Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");

        btnstart.setTypeface(MMedium);
        btnstop.setTypeface(MMedium);
    }

}