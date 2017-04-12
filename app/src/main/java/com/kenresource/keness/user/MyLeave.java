package com.kenresource.keness.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MyLeave extends AppCompatActivity {
CardView publicholiday,leaveApplication,leaveStatus, employeeAttendance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My leave");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        publicholiday=(CardView)findViewById(R.id.public_holiday);

        publicholiday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyLeave.this,PublicHolidayActivity.class));
            }
        });

        leaveApplication=(CardView)findViewById(R.id.leave_application);
        leaveApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyLeave.this,LeaveApplicationActivity.class));
            }
        });
        leaveStatus=(CardView)findViewById(R.id.leave_status);
        leaveStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyLeave.this,LeaveStatusActivity.class));
            }
        });
        employeeAttendance = (CardView)findViewById(R.id.employee_attendance);
        employeeAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyLeave.this,MyMapActivity.class));
            }
        });
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
