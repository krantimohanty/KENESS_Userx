package com.kenresource.keness.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by kranti on 2/18/2017.
 */


public class DependentActivity extends AppCompatActivity {
    private EditText edt_father_no,edt_guardian_no,edt_guardian_address,edt_other_phone;
    private TextView text_father_no,text_guardian_no,text_guardian_address,text_other_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependent);
        edt_father_no=(EditText)findViewById(R.id.Father_no);
        edt_guardian_no=(EditText)findViewById(R.id.Guardian_no);
        edt_guardian_address=(EditText)findViewById(R.id.Guardian_address);
        edt_other_phone=(EditText)findViewById(R.id.Other_Phone_No_if_any);

    }
}