package com.example.surftrac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button mSignupPage = findViewById(R.id.SignUpNow);
        mSignupPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, HomePage.class);
                startActivity(intent);
            }
        });

    }

    public static Intent intentFactory (Context context) {
        return new Intent(context, SignUp.class);
    }

}