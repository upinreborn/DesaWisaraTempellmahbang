package com.example.desawisaratempellmahbang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class update_user extends AppCompatActivity {

    public SharedPreferences mPreferences;
    public static final String mSharedPrefFile =
            "com.example.desawisaratempellmahbang";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        EditText eUsername = findViewById(R.id.updateUsername);
        EditText ePassword = findViewById(R.id.updatePassword);
        Button btnSignup = findViewById(R.id.update);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //validasi jika username dan password belum pernah didaftarkan
                if (eUsername.getText().toString().equals("") ||
                        ePassword.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"data must be completed",Toast.LENGTH_SHORT).show();
                } else{
                    mPreferences=getSharedPreferences(mSharedPrefFile,
                            Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor=mPreferences.edit();

                    editor.putString("Username",eUsername.getText().toString());
                    editor.putString("Password",ePassword.getText().toString());
                    editor.commit();
                    pesan();
                }
            }

            private void pesan()
            {
                Toast update = Toast.makeText(getApplicationContext(),"data updated successfully",Toast.LENGTH_SHORT);
                update.show();

                Intent btnlogin = new Intent(update_user.this, MainActivity.class);
                startActivity(btnlogin);
                finish();
            }
        });
    }
}