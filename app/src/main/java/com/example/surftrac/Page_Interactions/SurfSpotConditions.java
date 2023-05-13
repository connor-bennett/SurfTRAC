package com.example.surftrac.Page_Interactions;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.surftrac.DB.AppDataBase;
import com.example.surftrac.DB.ConditionsDAO;
import com.example.surftrac.R;
import com.example.surftrac.table_objects.Conditions;
import com.example.surftrac.table_objects.Surf_Log;
import com.example.surftrac.table_objects.User;

import java.util.List;


public class SurfSpotConditions extends AppCompatActivity {

    TextView ConditionsDisplay;
    ConditionsDAO ConditionAccessPoint;
    List<Conditions> allConditions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surf_spots);

        ConditionsDisplay = findViewById(R.id.DisplayConditions);
        ConditionsDisplay.setMovementMethod(new ScrollingMovementMethod());

        getDatabase();
        getDefaultCondition();
        refreshDisplay();

    }

    // get db
    private void getDatabase(){
        ConditionAccessPoint = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.CONDITIONS_TABLE)
                .allowMainThreadQueries()
                .build()
                .getConditionsDAO();
    }

    private void getDefaultCondition(){
        List<Conditions> conditionsList = ConditionAccessPoint.getAllConditions();
        if(conditionsList.size() <= 0){
            Conditions Reefs = new Conditions(6, 17, "SW", 3, "Reefs");
            Conditions Lovers = new Conditions(10, 22, "NW", 3, "Lovers Point");
            ConditionAccessPoint.insert(Reefs, Lovers);
        }
    }


    public void refreshDisplay(){
        allConditions = ConditionAccessPoint.getAllConditions();
        if(!allConditions.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for(Conditions log: allConditions){
                sb.append(log.toString());
            }
            ConditionsDisplay.setText(sb.toString());
        }else{
            ConditionsDisplay.setText(R.string.No_conds_listed);
        }
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
                Intent intent = new Intent(SurfSpotConditions.this, MainActivity.class);
                startActivity(intent);
                //TODO create Logout Method
                return true;
            case R.id.sub_item_back:
                Toast.makeText(this, "Clicked back to last page", Toast.LENGTH_SHORT).show();
                Intent intent_one = new Intent(SurfSpotConditions.this, HomePage.class);
                startActivity(intent_one);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    TODO maybe delete this
//
//    public static Intent intentFactory(Context context,String username,  boolean admin){
//        Intent intent = new Intent(context, SurfSpotConditions.class);
//        intent.putExtra(Key, admin);
//
////        intent.putExtra(ADMIN_CHECK, admin);
//        return intent;
//    }

}