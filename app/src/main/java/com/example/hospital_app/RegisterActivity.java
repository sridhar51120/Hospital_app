package com.example.hospital_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername,edEmail,edPassword,edConform;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edUsername = findViewById(R.id.editTextRegicUsername);
        edEmail = findViewById((R.id.editTextRegicEmail));
        edPassword = findViewById((R.id.editTextRegicPassword));
        edConform = findViewById((R.id.editTextRegicRepeatPassword));
        btn = findViewById((R.id.SignupButton));
        tv = findViewById((R.id.textViewRegisteredUser));

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String conform = edConform.getText().toString();
                Database db = new Database(getApplicationContext(),"Health Care",null,1);

                if(username.length() == 0 || email.length() == 0 || password.length() == 0 || conform.length() == 0){
                    Toast.makeText(getApplicationContext(),"Please fill All  Details",Toast.LENGTH_SHORT).show();
                } else {
                    if(password.compareTo(conform) == 0){
                        if(isValid(password)){

                            Toast.makeText(getApplicationContext(),"Record Inserted",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters, having letter, digit and special symbol", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Password and conform password didn't match",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public static boolean isValid(String Passworddhere){
        int f1=0,f2=0,f3=0;
        if(Passworddhere.length()< 8){
            return false;
        } else {
            for(int p=0;p<Passworddhere.length();p++){
                if(Character.isLetter(Passworddhere.charAt(p))){
                    f1=1;
                }
            }
            for(int r=0;r< Passworddhere.length();r++){
                if(Character.isDigit(Passworddhere.charAt(r))){
                    f2 = 1;
                }
            }
            for(int s = 0;s<Passworddhere.length();s++) {
                char c = Passworddhere.charAt(s);
                if (c > 33 && c <= 46 || c == 64) {
                    f3 = 1;
                }
            }
            if(f1 == 1 && f2 == 1 && f3 == 1){
                return true;
            }
            else {
                return false;
            }
        }

    }
}