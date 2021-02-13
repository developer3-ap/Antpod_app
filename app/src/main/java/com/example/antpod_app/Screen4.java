package com.example.antpod_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

public class Screen4 extends AppCompatActivity {
    PopupWindow popupWindow;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);

        constraintLayout = (ConstraintLayout)findViewById(R.id.constraint_layout);
        Button button = (Button)findViewById(R.id.done);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //instantiate the popup.xml layout file
                LayoutInflater layoutInflater = (LayoutInflater)Screen4.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customview = layoutInflater.inflate(R.layout.popup_window3,null);
                popupWindow = new PopupWindow(customview, ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
                popupWindow.showAtLocation(constraintLayout, Gravity.CENTER,0,0);
            }
        });
    }
}