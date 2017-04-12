package com.kenresource.keness.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

public class AttendanceActivity extends AppCompatActivity {
    LinearLayout layout_date, layout_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My Attendance");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        layout_date = (LinearLayout)findViewById(R.id.layout_date);
        layout_time = (LinearLayout)findViewById(R.id.layout_time);
        Button button =(Button)findViewById(R.id.register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_date.setVisibility(View.VISIBLE);
                layout_time.setVisibility(View.VISIBLE);
            }
        });
        TextView txt_date = (TextView)findViewById(R.id.date) ;
        TextView txt_time = (TextView)findViewById(R.id.time) ;
        Calendar c = Calendar.getInstance();

        int seconds = c.get(Calendar.SECOND);
        int minutes = c.get(Calendar.MINUTE);
        int hour = c.get(Calendar.HOUR);
        String time = hour+":"+minutes+":"+seconds;


        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH) + 1 ;
        int year = c.get(Calendar.YEAR);
        String date = day+"/"+month+"/"+year;

        //assuming that you need date and time in separate textview named txt_date and txt_time.

        txt_date.setText(date);
        txt_time.setText(time);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
