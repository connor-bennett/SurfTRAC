package com.example.surftrac.Page_Interactions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.surftrac.DB.AppDataBase;
import com.example.surftrac.DB.SurfLogDAO;
import com.example.surftrac.R;
import com.example.surftrac.table_objects.Surf_Log;

import java.util.List;

public class ViewPastSession extends AppCompatActivity {

    List<Surf_Log> All_Logs;
    List <Surf_Log> Location_Logs;

    EditText Search_by_Location;
    Button Search_Button;
    String Search_by_LocationString;
    SurfLogDAO surfLofDAO_AccessPoint;
    private TextView mDisplayBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_past_session);

        getDatabase();
        wireUpDisplay();
        mDisplayBox.setMovementMethod(new ScrollingMovementMethod());


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
                Intent intent = new Intent(ViewPastSession.this, MainActivity.class);
                startActivity(intent);
                //TODO create Logout Method
                return true;
            case R.id.sub_item_back:
                Toast.makeText(this, "Clicked back to last page", Toast.LENGTH_SHORT).show();
                Intent intent_one = new Intent(ViewPastSession.this, HomePage.class);
                startActivity(intent_one);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void getValuesFromDisplay(){
        Search_by_LocationString = Search_by_Location.getText().toString();
    }

    private void getDatabase(){
        surfLofDAO_AccessPoint = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.Surf_LOG_TABLE)
                .allowMainThreadQueries()
                .build()
                .getSurfLogDAO();
    }

    public void wireUpDisplay(){
        Search_by_Location = findViewById(R.id.Search_by_spot_name_edittext);
        Search_Button = findViewById(R.id.Search_button_pastSesh);
        mDisplayBox = findViewById(R.id.Display_past_sessions);

        Search_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getValuesFromDisplay();

                if(Search_by_LocationString == null){
                    All_Logs = surfLofDAO_AccessPoint.getAllSurfLogs();
                    Toast.makeText(ViewPastSession.this, "Searching logs by location", Toast.LENGTH_SHORT).show();
                    refreshDisplayLogsByLocation();
                }
                if(Search_by_LocationString != null){
                    Location_Logs = surfLofDAO_AccessPoint.getSurfLogByLocation(Search_by_LocationString);
                    Toast.makeText(ViewPastSession.this, "Searching all logs", Toast.LENGTH_SHORT).show();
                    refreshDisplayAllLogs();
                }

            }
        });
    }

    public void refreshDisplayAllLogs(){
        All_Logs = surfLofDAO_AccessPoint.getAllSurfLogs();
        if(!All_Logs.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for(Surf_Log log: All_Logs){
                sb.append(log.toString());
            }
            mDisplayBox.setText(sb.toString());
        }else{
            mDisplayBox.setText(R.string.No_logs_message);
        }
    }

    public void refreshDisplayLogsByLocation(){
        Location_Logs = surfLofDAO_AccessPoint.getSurfLogByLocation(Search_by_LocationString);
        if(!Location_Logs.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for(Surf_Log log: Location_Logs){
                sb.append(log.toString());
            }
            mDisplayBox.setText(sb.toString());
        }else{
            mDisplayBox.setText(getString(R.string.no_logs_for_location) + Search_by_LocationString);
        }
    }



}