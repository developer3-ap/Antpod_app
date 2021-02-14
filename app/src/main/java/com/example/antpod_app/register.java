package com.example.antpod_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bl) {
        super.onCreate(bl);
        setContentView(R.layout.register_layout);

        Button getotp = findViewById(R.id.getotp);
        getotp.setOnClickListener(v -> {
            Intent intent = new Intent(register.this,OTP_layout.class);
            startActivity(intent);
        });
    }

}
