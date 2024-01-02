package com.example.loggedin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText name, passward, address, phonenum;
    String userName, userPass, userAdd, userPhone;

    Button push;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.uname);
        passward = findViewById(R.id.upass);
        address = findViewById(R.id.uadd);
        phonenum = findViewById(R.id.uphone);

        push = findViewById(R.id.regbutton);


        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userName = name.getText().toString();
                userPass = passward.getText().toString();
                userAdd = address.getText().toString();
                userPhone = phonenum.getText().toString();

                if (userName.equals("")) {
                    name.setError("Please fill out the field");
                } else if (userPass.equals("")) {
                    passward.setError("Please fill out the field");

                } else if (userAdd.equals("")) {
                    address.setError("Please fill out the field");

                } else if (userPhone.equals("")) {
                    phonenum.setError("Please fill out the field");
                }
                else {

                }
            }
        });



    }
}