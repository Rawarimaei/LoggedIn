package com.example.loggedin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lstTodos;


    TextView tv;
    EditText name, password;
    String Name, Password;
    Button btn;

    SharedPreferences sharedPreferences;

    private static final String Shardpreferencename = "Mypref";
    private static final String Kayname = "name";
    private static final String Kaypass = "password";

    public  static final String shar_pre = "shard";

    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "https://jsonplaceholder.typicode.com/todos/1";

        JsonObjectRequest request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                tv.setText(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tv.setText("error");

            }
        });


        tv = findViewById(R.id.switchl);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        btn = findViewById(R.id.button);

        sharedPreferences = getSharedPreferences(Shardpreferencename, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().length() == 0) {
                    name.setError("Enter Name");

                } else if (password.getText().length() == 0) {
                    password.setError("Enter password");

                } else {
                    editor.putString(Kayname, name.getText().toString());
                    editor.putString(Kaypass, password.getText().toString());
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Login Successfuly", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                    startActivity(intent);
                }

            }
        });
    }


    public void btn_OnClick(View view) {



    }
}