package com.inkrealm.mirror;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoadingActivity extends AppCompatActivity {

    private static final int LOADING_DURATION = 3000; // 3 seconds
    private ImageView lionImageView;
    private TextView loadingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Make activity fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
                
        setContentView(R.layout.activity_loading);

        initializeViews();
        startAnimations();
        navigateToMain();
    }

    private void initializeViews() {
        lionImageView = findViewById(R.id.lionImageView);
        loadingTextView = findViewById(R.id.loadingTextView);
    }

    private void startAnimations() {
        // Load and start lion roar animation
        Animation lionAnimation = AnimationUtils.loadAnimation(this, R.anim.lion_roar);
        lionImageView.startAnimation(lionAnimation);

        // Load and start text fade animation
        Animation textAnimation = AnimationUtils.loadAnimation(this, R.anim.text_fade);
        loadingTextView.startAnimation(textAnimation);
    }

    private void navigateToMain() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(LoadingActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, LOADING_DURATION);
    }
}