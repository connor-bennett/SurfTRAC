package com.example.surftrac.Page_Interactions;

import static android.view.View.VISIBLE;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.surftrac.R;

public class HomePage extends AppCompatActivity {

    Button mEditConds;
    TextView mWelcomeMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mEditConds = findViewById(R.id.Edit_Conds_for_admin);

        Intent intent = getIntent();
        boolean adminCheck = intent.getBooleanExtra("Key", false);
        String userName = intent.getStringExtra("user");

        mWelcomeMsg = findViewById(R.id.welcomeMsg);
        mWelcomeMsg.setText(userName);

        Toast.makeText(this, "" + adminCheck, Toast.LENGTH_SHORT).show();

        checkForAdmin(adminCheck);

        Button mLogNewSession = findViewById(R.id.Log_new_sesh_button);
        mLogNewSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, LogNewSession.class);
                startActivity(intent);
            }
        });

        Button mViewPastSessions = findViewById(R.id.past_sesh_button);
        mViewPastSessions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, ViewPastSession.class);
                startActivity(intent);
            }
        });

        Button mSurfSpot_Conditions = findViewById(R.id.Surf_conditions_button);
        mSurfSpot_Conditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, SurfSpotConditions.class);
                startActivity(intent);
            }
        });

        mEditConds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, EditConditions.class);
                startActivity(intent);
            }
        });

    }

    public void checkForAdmin(boolean admin){
        if(!admin){
            mEditConds.setVisibility(View.INVISIBLE);
        }
    }

    public static Intent intentFactory (Context context) {
        return new Intent(context, HomePage.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.sub_item_log_out:
                Toast.makeText(this, "Clicked Log out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomePage.this, MainActivity.class);
                startActivity(intent);
                //TODO create Logout Method
                return true;
            case R.id.sub_item_back:
                Toast.makeText(this, "Cannot go back from HomePage", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public static Intent intentFactory(Context context, String username, boolean admin) {
        Intent intent = new Intent(context, HomePage.class);
        intent.putExtra("Username", username);
        intent.putExtra("Admin", admin);
        return intent;
    }


}