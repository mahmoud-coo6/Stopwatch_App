package com.example.stopwatchapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvSplash, tvSubSplash;
    Button btnget;
    Animation atg, btgone, btgtwo;
    ImageView ivSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSplash= findViewById(R.id.tvSplach);
        tvSubSplash= findViewById(R.id.tvSubSplach);
        btnget= findViewById(R.id.btngent);
        ivSplash= findViewById(R.id.ivSplach);

        atg= AnimationUtils.loadAnimation(this, R.anim.arg);
        btgone= AnimationUtils.loadAnimation(this, R.anim.btgone);
        btgtwo= AnimationUtils.loadAnimation(this, R.anim.btgtwo);

        ivSplash.startAnimation(atg);
        ivSplash.startAnimation(btgone);
        tvSubSplash.startAnimation(btgone);
        btnget.startAnimation(btgtwo);

        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this,  StopWatchAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        Typeface MLight= Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium= Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface MRegular= Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");


        tvSplash.setTypeface(MRegular);
        tvSubSplash.setTypeface(MLight);
        btnget.setTypeface(MMedium);
    }
}