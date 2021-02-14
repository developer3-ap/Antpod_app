package com.example.antpod_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class Aboutyou extends AppCompatActivity {
    EditText dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutyou);

        dob = findViewById(R.id.dob);
        dob.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(Aboutyou.this, (view, year1, month1, dayOfMonth) -> dob.setText(dayOfMonth + "-" + (month1 + 1) + "-" + year1), year,month,day);
            datePickerDialog.show();
        });

        Button next_button = findViewById(R.id.next_button);
        next_button.setOnClickListener(v -> {
            Intent intent = new Intent(Aboutyou.this,Screen3.class);
            startActivity(intent);
        });
    }
}