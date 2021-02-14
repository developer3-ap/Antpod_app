package com.example.antpod_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login_button = findViewById(R.id.Login_button);
        Button Newuser_button = findViewById(R.id.Newuser_button);
        Newuser_button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, register.class);
            startActivity(intent);
        });
    }
}