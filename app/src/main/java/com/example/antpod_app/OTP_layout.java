package com.example.antpod_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OTP_layout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_layout);

        Button verify_button = findViewById(R.id.verify_button);
        verify_button.setOnClickListener(v -> {
            Intent intent = new Intent(OTP_layout.this,Aboutyou.class);
            startActivity(intent);
        });
    }
}