package com.rajsabari.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    Intent newuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = findViewById(R.id.login);
        EditText user = findViewById(R.id.edituser);
        EditText pass = findViewById(R.id.editpassword);
        TextView newsign = findViewById(R.id.signup);
        intent = new Intent(this, SignUp.class);
        newuser = new Intent(this, Newuser.class);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user.getText().toString();
                String password = pass.getText().toString();
                SharedPreferences prefs = getSharedPreferences("localdb", MODE_PRIVATE);
                String usernameequal = prefs.getString("username", "No name defined");
                String passwordequal = prefs.getString("password", "No name defined");//"No name defined" is the default value.
                if (username.equals(usernameequal) && password.equals(passwordequal)) {
                    Toast.makeText(MainActivity.this, "Welcome  " + username, Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "INVALID", Toast.LENGTH_SHORT).show();
                }
            }
        });
        newsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "SignUp", Toast.LENGTH_SHORT).show();
                startActivity(newuser);
            }
        });

    }
}