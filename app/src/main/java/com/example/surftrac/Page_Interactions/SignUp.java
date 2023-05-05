package com.example.surftrac.Page_Interactions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.surftrac.R;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sub_item_log_out:
                Toast.makeText(this, "You are not logged in", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sub_item_back:
                Toast.makeText(this, "Clicked Back", Toast.LENGTH_SHORT).show();
                Intent intent_one = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent_one);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}