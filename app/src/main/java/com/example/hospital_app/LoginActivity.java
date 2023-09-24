package com.example.hospital_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    EditText edUsername, edPassword;
    Button btn;
    TextView tv;
    private Intent RegisterActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername = findViewById(R.id.editTextLoginUsername);
        edPassword = findViewById(R.id.editTextLoginPassword);
        btn = findViewById(R.id.LoginButton);
        tv = findViewById(R.id.textViewRegisteredUser);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                if(username.length() == 0 || password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please Fill all the Details", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show();
                }
            }

        });

        tv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }
}