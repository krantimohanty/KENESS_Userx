/**
 * Created by yasmin.n on 2/18/2017.
 */package com.kenresource.keness.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class PersonalDetailsActivity extends AppCompatActivity {
    private EditText edt_name,edt_fathername,edt_mothername,edt_dateofbirth,edt_bloodgroup,edt_gender,edt_maritalstatus;
    private TextView text_name,text_fathername,text_mothername,text_dateofbirth,text_bloodgroup,text_gender,text_maritalstatus;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Personal Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        edt_name=(EditText)findViewById(R.id.Name);
//        edt_fathername=(EditText)findViewById(R.id.Father_name);
//        edt_mothername=(EditText)findViewById(R.id.Mother_name);
//        edt_dateofbirth=(EditText)findViewById(R.id.Date_of_Birth);
//        edt_bloodgroup=(EditText)findViewById(R.id.Blood_group);
//        edt_gender=(EditText)findViewById(R.id.Gender);
//        edt_maritalstatus=(EditText)findViewById(R.id.Marital_Status);


      //  class_edt = (EditText) findViewById(R.id.edit_class);
//        final TextView tv = new TextView(this);
//
// String name=edt_name.getText().toString().trim();
//        String fathername=edt_fathername.getText().toString().trim();
//        String mothername=edt_mothername.getText().toString().trim();
//        String dateofBirth=edt_dateofbirth.getText().toString().trim();
//        String bloodgroup=edt_bloodgroup.getText().toString().trim();
//        String gender=edt_gender.getText().toString().trim();
//        String maritalstatus=edt_maritalstatus.getText().toString().trim();




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
