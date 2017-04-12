package com.kenresource.keness.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by yasmin.n on 2/18/2017.
 */

public class EmergencyActivity extends AppCompatActivity {
    private EditText edt_guardian,edt_emergency;
    private TextView text_guardian,text_emergency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        edt_guardian=(EditText)findViewById(R.id.Guardian_No);
        edt_emergency=(EditText)findViewById(R.id.Emergency_No);


    }
}
