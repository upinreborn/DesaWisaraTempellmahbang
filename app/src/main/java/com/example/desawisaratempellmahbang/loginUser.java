package com.example.desawisaratempellmahbang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class loginUser extends AppCompatActivity {

    TextView btndaftar;
    EditText ePassword, eUsername;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        TextView btndaftar =  findViewById(R.id.btnSignupInLogin);
        Button btnlogin = findViewById(R.id.btnlogin);
        EditText ePassword = findViewById(R.id.ePassword);
        EditText eUsername = findViewById(R.id.eUsername);

        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent daftar = new Intent(loginUser.this, registerUser.class);
                startActivity(daftar);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences mPreferences;
                String mSharedPrefFile =
                        "com.example.desawisaratempellmahbang";

                mPreferences=getSharedPreferences(mSharedPrefFile,
                        Activity.MODE_PRIVATE);


                if(mPreferences.getString("Username", null) == null || mPreferences.getString("Password",null)==null){
                    Toast.makeText(getApplicationContext(),"data not found",Toast.LENGTH_SHORT).show();
                }else {

                    String uname = mPreferences.getString("Username",null);
                    String pwd = mPreferences.getString("Password",null);

                    if (uname.equals(eUsername.getText().toString()) && pwd.equals(ePassword.getText().toString())){
                        Intent intent = new Intent(loginUser.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if(eUsername.getText().toString().equals("") || ePassword.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(), "username and password must be filled", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Wrong username or Password", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}