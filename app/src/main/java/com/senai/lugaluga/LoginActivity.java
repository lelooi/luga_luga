package com.senai.lugaluga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    private Button buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonLogin = findViewById(R.id.supabutton);

        Intent intent = new Intent(this, MainActivity.class);
        buttonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V) {
                startActivity(intent);
            }
        });
    }
}