package com.rajsabari.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Newuser extends AppCompatActivity {
    Intent home;
    Intent login; //login page

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newuser);
        TextView exit = findViewById(R.id.loginpage);
        TextView username = findViewById(R.id.username);
        EditText usertype = findViewById(R.id.editname);
        TextView password = findViewById(R.id.password);
        EditText passtype = findViewById(R.id.editpass);
        Button summit = findViewById(R.id.summit);
        home = new Intent(this, MainActivity.class);
        login = new Intent(this, SignUp.class);
        summit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one = usertype.getText().toString();
                String two = passtype.getText().toString();
                if (!one.equals("") && !two.equals("")){
                    SharedPreferences.Editor editor = getSharedPreferences("localdb", MODE_PRIVATE).edit();
                    editor.putString("username", one);
                    editor.putString("password", two);
                    editor.apply();
                    Toast.makeText(Newuser.this, "DONE  " + one, Toast.LENGTH_SHORT).show();
                    startActivity(home);
                } else {
                    Toast.makeText(Newuser.this, "INVALID", Toast.LENGTH_SHORT).show();
                }

            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Newuser.this, "LOGIN PAGE", Toast.LENGTH_SHORT).show();
                startActivity(home);
            }
        });
    }
}