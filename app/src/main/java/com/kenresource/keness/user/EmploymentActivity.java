package com.kenresource.keness.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by yasmin.n on 2/18/2017.
 */

public class EmploymentActivity extends AppCompatActivity {
    private EditText edt_fresher_experienced,edt_experience_level,edt_company_name,edt_company_location,edt_position_title,edt_position_level,
                      edt_specialization,edt_industry_company,edt_duration,edt_salary;
    private TextView text_fresher_experienced,text_experience_level,text_company_name,text_company_location,text_position_title,
    text_position_level,text_specialization,text_duration,text_salary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employment);
        edt_fresher_experienced=(EditText)findViewById(R.id.Fresher_Experienced);
        edt_experience_level=(EditText)findViewById(R.id.Experience_level);
        edt_company_name=(EditText)findViewById(R.id.Company_Name);
        edt_company_location=(EditText)findViewById(R.id.Company_Location);
        edt_position_title=(EditText)findViewById(R.id.Position_Title);
        edt_position_level=(EditText)findViewById(R.id.Position_Level);
        edt_specialization=(EditText)findViewById(R.id.Specialization);

        edt_duration=(EditText)findViewById(R.id.Duration);
        edt_salary=(EditText)findViewById(R.id.Monthly_salary);


    }
}