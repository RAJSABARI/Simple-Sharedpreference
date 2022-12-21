package com.rajsabari.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;   ///
//SIGN UP = LOG IN
public class SignUp extends AppCompatActivity {
    Intent newuser;
    Intent main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        TextView open=findViewById(R.id.view);
        String op=getIntent().getStringExtra("key");
        open.setText("Hello  "+op);
        TextView exit = findViewById(R.id.exit);
        TextView signup = findViewById(R.id.signupOne);
        main =new Intent(this,MainActivity.class);
        newuser = new Intent(this, Newuser.class);
        signup.setOnClickListener(new View.OnClickListener() {   //SIGN UP =New account in UI design
            @Override
            public void onClick(View v) {
                Toast.makeText(SignUp.this, "SignUp", Toast.LENGTH_SHORT).show();
                startActivity(newuser);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignUp.this, "EXITED", Toast.LENGTH_SHORT).show();
                startActivity(main);
            }
        });
    }
}