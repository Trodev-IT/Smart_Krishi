package com.trodev.smartkrishi.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.trodev.smartkrishi.MainActivity;
import com.trodev.smartkrishi.R;

public class SplashActivity extends AppCompatActivity {
    //private FirebaseAuth firebaseAuth;

    TextView splash;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /*hide actionbar on the splash screen*/
        getSupportActionBar().hide();

        splash= findViewById(R.id.splash);

        splash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SplashActivity.this, "স্মার্ট কৃষিতে আপনাকে স্বাগতম", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SplashActivity.this, SignInActivity.class));
            }
        });

//        firebaseAuth = FirebaseAuth.getInstance();
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if (FirebaseAuth.getInstance().getCurrentUser() == null) {
//                    Intent intent = new Intent(SplashActivity.this, SignInActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
//                else {
//                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
//            }
//        }, 4000);

    }
}