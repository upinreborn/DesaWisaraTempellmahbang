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

public class registerUser extends AppCompatActivity {

    TextView btnlogin;
    Button btnSignup;
    EditText eUsername, eFullname, ePassword;
    public SharedPreferences mPreferences;
    public static final String mSharedPrefFile =
            "com.example.desawisaratempellmahbang";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        TextView btnlogin = findViewById(R.id.btnloginInRegister);
        EditText eUsername = findViewById(R.id.eUsername);
        EditText ePassword = findViewById(R.id.ePassword);
        EditText eFullname = findViewById(R.id.eFullname);
        Button btnSignup = findViewById(R.id.btnsignup);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(registerUser.this, loginUser.class);
                startActivity(login);
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //validasi jika username dan password belum pernah didaftarkan
                if (eUsername.getText().toString().equals("") ||
                        ePassword.getText().toString().equals("") ||
                        eFullname.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"data must be completed",Toast.LENGTH_SHORT).show();
                } else{
                    mPreferences=getSharedPreferences(mSharedPrefFile,
                            Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor=mPreferences.edit();

                    editor.putString("Username",eUsername.getText().toString());
                    editor.putString("Password",ePassword.getText().toString());
                    editor.putString("Fullname",eFullname.getText().toString());
                    editor.commit();
                    pesan();
                }
            }

            private void pesan()
            {
                AlertDialog.Builder psn=new
                        AlertDialog.Builder(registerUser.this);
                psn.setTitle("saved data");
                psn.setMessage("Data added successfully");
                psn.setIcon(R.drawable.ic_baseline_check_circle_24);
                psn.setNeutralButton("OK",new
                        DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface
                                                        dialogInterface, int i) {

                                Intent btnlogin = new Intent(registerUser.this, loginUser.class);
                                startActivity(btnlogin);
                                finish();
                            }
                        });
                psn.show();
            }
        });
    }
}