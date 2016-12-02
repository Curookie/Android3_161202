package com.example.curookie.project6_1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Chronometer cro;
    CalendarView cv;
    TimePicker tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        btn1 = (Button)findViewById(R.id.button);
        cro = (Chronometer)findViewById(R.id.chronometer);
        cv = (CalendarView)findViewById(R.id.calendarView);
        tp = (TimePicker)findViewById(R.id.timePicker);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cro.start();
                cro.setTextColor(Color.RED);
            }
        });
    }
}
