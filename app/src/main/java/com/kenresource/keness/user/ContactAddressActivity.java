package com.kenresource.keness.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.view.View;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.widget.TextView;

/**
 * Created by yasmin.n on 2/18/2017.
 */

public class ContactAddressActivity extends AppCompatActivity {
    private EditText edt_phone, edt_mobile, edt_tempaddress, edt_permaddress, edt_email, edt_city, edt_state, edt_pin, edt_country;
    private TextView text_phone, text_mobile, text_tempaddress, text_permaddress, text_email, text_city, text_state, text_pin, text_country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_address);
        edt_phone = (EditText) findViewById(R.id.Phone_No);
        edt_mobile = (EditText) findViewById(R.id.Mobile_No);
        edt_tempaddress = (EditText) findViewById(R.id.temporary_address);
        edt_permaddress = (EditText) findViewById(R.id.Permanent_address);
        edt_email = (EditText) findViewById(R.id.email_id);
        edt_city = (EditText) findViewById(R.id.City);
        edt_state = (EditText) findViewById(R.id.State);
        edt_pin = (EditText) findViewById(R.id.Pin_Code);
        edt_country = (EditText) findViewById(R.id.Country);

        String phone = edt_phone.getText().toString().trim();
        String mobile = edt_mobile.getText().toString().trim();
        String tempaddress = edt_tempaddress.getText().toString().trim();
        String permaddress = edt_permaddress.getText().toString().trim();
        String email = edt_email.getText().toString().trim();
        String city = edt_city.getText().toString().trim();
        String state = edt_state.getText().toString().trim();
        String pin = edt_pin.getText().toString().trim();
        String country = edt_country.getText().toString().trim();
    }


    public void onClick(View arg0) {

        final String email = edt_email.getText().toString();
        if (!isValidEmail(email)) {
            edt_email.setError("Invalid Email");
        }
    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}

