package com.example.surftrac.Page_Interactions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.surftrac.DB.AppDataBase;
import com.example.surftrac.DB.ConditionsDAO;
import com.example.surftrac.R;

public class LogNewSession extends AppCompatActivity {

    EditText mSwellHeight;
    EditText mSwellDirection;
    EditText mSwellPeriod;
    EditText mTide;
    EditText mSpotName;
    Button mLogSession;

    ConditionsDAO ConditionsAccessPoint;

    private void getValuesFromDisplay(){
        mSwellHeight = findViewById(R.id.Log_sess_SwellHeight_edittext);
        mSwellDirection = findViewById(R.id.EnterSwellDir_logSess_edittext);
        mSwellPeriod = findViewById(R.id.SwellPeriod_logsess_edittext);
        mTide = findViewById(R.id.Enter_tide_logsess_edittext);
        mSpotName = findViewById(R.id.SpotName_LogSess);
        mLogSession = findViewById(R.id.LogSess_Button);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_new_session);
        getValuesFromDisplay();

        mLogSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    // Store Default Users and get db
    private void getDatabase(){
        ConditionsAccessPoint = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.CONDITIONS_TABLE)
                .allowMainThreadQueries()
                .build()
                .getConditionsDAO();
    }



// Menu item on create
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }

    // Menu item log out functionality
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.sub_item_log_out:
                Toast.makeText(this, "Clicked Log out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LogNewSession.this, MainActivity.class);
                startActivity(intent);
                //TODO create Logout Method
                return true;
            case R.id.sub_item_back:
                Toast.makeText(this, "Clicked back to last page", Toast.LENGTH_SHORT).show();
                Intent intent_one = new Intent(LogNewSession.this, HomePage.class);
                startActivity(intent_one);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}