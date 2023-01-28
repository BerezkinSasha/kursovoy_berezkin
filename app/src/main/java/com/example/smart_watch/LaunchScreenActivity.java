package com.example.smart_watch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.smart_watch.databinding.ActivityLaunchScreenBinding;
import com.example.smart_watch.databinding.ActivityMainBinding;

public class LaunchScreenActivity extends Activity {

    private ActivityLaunchScreenBinding binding;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);

        binding = ActivityLaunchScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        imageView = findViewById(R.id.splash_screen);
        imageView.setImageResource(R.drawable.splash);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        imageView.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LaunchScreenActivity.this, SignInActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2200);

    }
}