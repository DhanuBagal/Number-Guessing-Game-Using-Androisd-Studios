package com.example.numberguessing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN =5000;
    TextView textview,textview1;
    ImageView imageView;
    Animation topanim,bottomanim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        textview= findViewById(R.id.textView);
        textview1=findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView2);
        topanim= AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomanim= AnimationUtils.loadAnimation(this, R.anim.bottom_amination);

        imageView.setAnimation(topanim);
        textview.setAnimation(bottomanim);
        textview1.setAnimation(bottomanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(MainActivity.this,StartPage.class);
                startActivity(i);
                finish();
            }
        },SPLASH_SCREEN);
    }
}