package com.example.antpod_app;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import java.util.Calendar;

import static android.R.layout.simple_spinner_dropdown_item;

public class Screen3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    String[] spinner_options = {"option1","option2","option3","option4","option5"};
    Spinner spinner2,spinner3;
    String[] spinner_options3 = {"1","2","3","4","5","6","7","8","9","10"};
    String[] spinner_options2 = {"1","2","3","4","5","6","7","8","9","10"};
    ConstraintLayout constraintLayout;
    EditText date;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);

        Button next_button2 = findViewById(R.id.next_button2);
        next_button2.setOnClickListener(v -> {
            Intent intent = new Intent(Screen3.this,Screen4.class);
            startActivity(intent);
        });

        constraintLayout = findViewById(R.id.constraint_layout);

        // spinner code
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinner_options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter.notifyDataSetChanged();
        spinner.setAdapter(adapter);
        spinner.setBackgroundColor(Color.BLACK);
        spinner.setOnItemSelectedListener(this);

        // edittext popup
        EditText popup1 = findViewById(R.id.popup);
        popup1.setOnTouchListener((View.OnTouchListener) (v, event) -> {
            LayoutInflater layoutInflater = (LayoutInflater) Screen3.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View customview = layoutInflater.inflate(R.layout.popup_window,null);

            PopupWindow popupWindow = new PopupWindow(customview, ConstraintLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            popupWindow.showAtLocation(constraintLayout, Gravity.CENTER,0,0);
            popupWindow.setOutsideTouchable(true);

            spinner2 = customview.findViewById(R.id.spinner);
            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Screen3.this, simple_spinner_dropdown_item, spinner_options2);
            adapter1.setDropDownViewResource(simple_spinner_dropdown_item);
            adapter1.notifyDataSetChanged();
            spinner2.setAdapter(adapter1);
            spinner2.setOnItemSelectedListener(Screen3.this);

            Button b1 = customview.findViewById(R.id.done);
            b1.setOnClickListener(v1 -> popupWindow.dismiss());
            return true;
        });

        EditText popup2 = findViewById(R.id.popup2);
        popup2.setOnTouchListener((View.OnTouchListener) (v, event) -> {
            LayoutInflater layoutInflater = (LayoutInflater) Screen3.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View customview = layoutInflater.inflate(R.layout.popup_window2,null);

            constraintLayout.setBackgroundColor(Color.GRAY);
            PopupWindow popupWindow = new PopupWindow(customview, ConstraintLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            popupWindow.showAtLocation(constraintLayout, Gravity.CENTER,0,0);

            spinner3 = customview.findViewById(R.id.spinner);
            ArrayAdapter<String> adapter12 = new ArrayAdapter<String>(Screen3.this, simple_spinner_dropdown_item, spinner_options3);
            adapter12.setDropDownViewResource(simple_spinner_dropdown_item);
            adapter12.notifyDataSetChanged();
            spinner3.setAdapter(adapter12);
            spinner3.setOnItemSelectedListener(Screen3.this);

            Button b1 = (Button)customview.findViewById(R.id.done);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                }
            });
            return true;
        });

        date =  findViewById(R.id.date_field);
        date.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.date_field) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year1, month1, dayOfMonth) -> date.setText(dayOfMonth + "-" + (month1 + 1) + "-" + year1), year,month,day);
            datePickerDialog.show();
        }
    }
}