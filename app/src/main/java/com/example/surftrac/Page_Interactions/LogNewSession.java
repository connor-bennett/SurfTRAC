package com.example.surftrac.Page_Interactions;

import static java.lang.Integer.parseInt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
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
import com.example.surftrac.DB.SurfLogDAO;
import com.example.surftrac.R;
import com.example.surftrac.table_objects.Surf_Log;

import java.util.List;

public class LogNewSession extends AppCompatActivity {

    // instantiate edittexts
    EditText mSwellHeight;
    EditText mSwellDirection;
    EditText mSwellPeriod;
    EditText mTide;
    EditText mSpotName;
    Button mLogSession;

    // int and string values

    String mStringSwellHeight;
    String mStringSwellPeriod;
    String mStringTide;
    int mIntSwellHeight;
    int mIntSwellPeriod;
    int mIntTide;
    String mStringSpotName;
    String mStringSwellDirection;

    SurfLogDAO surfLogDAO_AccessPoint;



    private void wireUpDisplay(){

        // instantiate edittexts
      mSwellHeight = findViewById(R.id.Log_sess_SwellHeight_edittext);
      mSwellDirection = findViewById(R.id.EnterSwellDir_logSess_edittext);
      mSwellPeriod = findViewById(R.id.SwellPeriod_logsess_edittext);
      mTide = findViewById(R.id.Enter_tide_logsess_edittext);
      mSpotName = findViewById(R.id.SpotName_LogSess);
      mLogSession = findViewById(R.id.LogSess_Button);

        mLogSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getValuesFromDisplay();
                logNewSession();
                List <Surf_Log> LogList = surfLogDAO_AccessPoint.getAllSurfLogs();
                if(LogList.size() <= 0){
                    Toast.makeText(LogNewSession.this, "No sessions Logged", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LogNewSession.this, "Session logged", Toast.LENGTH_SHORT).show();
                }

                mSwellHeight.setText("");
                mSwellDirection.setText("");
                mSwellPeriod.setText("");
                mTide.setText("");
                mSpotName.setText("");
                mLogSession.setText("");

            }
        });

    }


    private void getValuesFromDisplay() {
        //String values of
        mStringSwellHeight = mSwellHeight.getText().toString();
        mStringSwellPeriod = mSwellPeriod.getText().toString();
        mStringTide = mTide.getText().toString();
        mStringSwellDirection = mSwellDirection.getText().toString();
        mStringSpotName = mSpotName.getText().toString();

        if(!mStringSwellHeight.isEmpty() && !mStringSwellPeriod.isEmpty() && !mStringTide.isEmpty()){
            // Int values of
            mIntSwellHeight = parseInt(mStringSwellHeight);
            mIntSwellPeriod = parseInt(mStringSwellPeriod);
            mIntTide = parseInt(mStringTide);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_new_session);

        getDatabase();
        wireUpDisplay();

    }

    // Store Default Users and get db
    private void getDatabase(){
        surfLogDAO_AccessPoint = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.Surf_LOG_TABLE)
                .allowMainThreadQueries()
                .build()
                .getSurfLogDAO();
    }

    private void logNewSession(){
        getValuesFromDisplay();
        Surf_Log log = new Surf_Log(mIntSwellHeight, mIntSwellPeriod, mStringSwellDirection, mStringSpotName, mIntTide);
        surfLogDAO_AccessPoint.insert(log);
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

    public static Intent intentFactory (Context context) {
        Intent intent = new Intent(context, LogNewSession.class);
        return intent;
    }


}