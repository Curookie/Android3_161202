package com.example.curookie.project6_1;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Button btn1, btnDone;
    Chronometer cro;
    CalendarView cv;
    TimePicker tp;
    RadioGroup rg;
    TextView tv;
    int year=-1;
    int mon=-1;
    int day=-1;
    int hour=-1;
    int min=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        btn1 = (Button)findViewById(R.id.button);
        cro = (Chronometer)findViewById(R.id.chronometer);
        cv = (CalendarView)findViewById(R.id.calendarView);
        tp = (TimePicker)findViewById(R.id.timePicker);
        rg = (RadioGroup)findViewById(R.id.rg);
        btnDone = (Button)findViewById(R.id.button2);
        tv = (TextView)findViewById(R.id.textView);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cro.setBase(SystemClock.elapsedRealtime());
                cro.start();
                cro.setTextColor(Color.RED);
            }
        });

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cro.stop();
                cro.setTextColor(0xff0099cc);
                tv.setText(year+"년"+mon+"월"+day+"일 "+hour+"시"+min+"분 예약됨");
            }
        });

        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                year=i; mon=i1; day=i2;
            }
        });

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                hour=i; min=i1;
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.radioButton) { cv.setVisibility(View.VISIBLE); tp.setVisibility(View.INVISIBLE); }
                else if(i==R.id.radioButton2) { tp.setVisibility(View.VISIBLE); cv.setVisibility(View.INVISIBLE); }
            }
        });
    }
}
