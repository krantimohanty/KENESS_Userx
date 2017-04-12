package com.kenresource.keness.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class ProfileMainActivity extends AppCompatActivity {
    private CardView personaldetail_butn, contactaddress_butn, employment_butn, identities_butn, dependent_butn, emergency_butn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        personaldetail_butn = (CardView) findViewById(R.id.btn_personal);
        contactaddress_butn = (CardView) findViewById(R.id.btn_contact);
        employment_butn = (CardView) findViewById(R.id.btn_employment);
        identities_butn = (CardView) findViewById(R.id.btn_identities);
        dependent_butn = (CardView) findViewById(R.id.btn_dependent);
        emergency_butn = (CardView) findViewById(R.id.btn_emergency);
        personaldetail_butn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ProfileMainActivity.this, PersonalDetailsActivity.class);
                startActivity(intent);
            }
        });

        contactaddress_butn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ProfileMainActivity.this, ContactAddressActivity.class);
                startActivity(intent);
            }
        });
//
//        employment_butn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(ProfileMainActivity.this, EmploymentActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        identities_butn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(ProfileMainActivity.this, IdentitiesActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        dependent_butn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(ProfileMainActivity.this, DependentActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//        emergency_butn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(ProfileMainActivity.this, EmergencyActivity.class);
//                startActivity(intent);
//            }
//        });

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