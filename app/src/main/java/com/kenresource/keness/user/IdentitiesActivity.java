package com.kenresource.keness.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by yasmin.n on 2/18/2017.
 */


public class IdentitiesActivity extends AppCompatActivity {
    private EditText edt_Nationality,edt_pan,edt_passport,edt_aadhar;
    private TextView text_Nationality,text_pan,text_passport,text_aadhar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identities);
        edt_Nationality=(EditText)findViewById(R.id.Nationality);
        edt_pan=(EditText)findViewById(R.id.Pan_Card);
        edt_passport=(EditText)findViewById(R.id.Pass_Port);
        edt_aadhar=(EditText)findViewById(R.id.Aadhar_card);

    }
}