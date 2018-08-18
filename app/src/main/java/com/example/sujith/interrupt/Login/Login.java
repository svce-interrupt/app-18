package com.example.sujith.interrupt.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sujith.interrupt.Activity.MainActivity;
import com.example.sujith.interrupt.R;

public class Login extends AppCompatActivity {

    Button sign_In;
    TextView reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sign_In = findViewById(R.id.button);
        reg = findViewById(R.id.regis);

        sign_In.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.login,new Register())
                        .commit();
                //Toast.makeText(Login.this, "Worked", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
