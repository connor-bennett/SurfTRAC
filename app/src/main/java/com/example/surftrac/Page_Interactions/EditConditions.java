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
import com.example.surftrac.DB.ConditionsDAO;
import com.example.surftrac.R;
import com.example.surftrac.table_objects.Conditions;

import java.util.List;

public class EditConditions extends AppCompatActivity {

//    Dao Related vars
    ConditionsDAO ConditionsAccessPoint;
    List<Conditions> ConditionsList;

// Xml Related vars
    Button addButton;
    Button deleteButton;
    EditText SwellHeight;
    EditText SwellPeriod;
    EditText SwellDirection;
    EditText Tide;
    EditText SpotName;

//    Vars taken form display
    String SwellDirectionString;
    String SwellHeightString;
    String SwellPeriodString;
    String TideString;
    String SpotNameString;
    int SwellPeriodInt;
    int SwellHeightInt;
    int TideInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_conditions);

        getDataBAse();
        wireUpDisplay();
    }

    public void getDataBAse(){
        ConditionsAccessPoint = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.CONDITIONS_TABLE)
                .allowMainThreadQueries()
                .build()
                .getConditionsDAO();
    }

    public void wireUpDisplay(){
        addButton = findViewById(R.id.Add_Condition_Button);
        deleteButton = findViewById(R.id.Conditions_Delete_Button);
        SwellDirection = findViewById(R.id.SwellDirection_Conditions_edittext);
        SwellHeight = findViewById(R.id.SwellHeight_Conditions_edittext);
        SwellPeriod = findViewById(R.id.SwellPeriod_Conditions_edittext);
        Tide = findViewById(R.id.Tide_Conditions_edittext);
        SpotName = findViewById(R.id.SpotName_Conditions_edittext);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getValuesFromDisplay();
                addConditions();


                SwellDirection.setText("");
                SpotName.setText("");
                SwellHeight.setText("");
                SwellPeriod.setText("");
                Tide.setText("");
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getValuesFromDisplay();
                deleteCondition();

                SwellDirection.setText("");
                SpotName.setText("");
                SwellHeight.setText("");
                SwellPeriod.setText("");
                Tide.setText("");
            }
        });

    }

    public void getValuesFromDisplay(){
        SwellDirectionString = SwellDirection.getText().toString();
        SwellHeightString = SwellHeight.getText().toString();
        SwellPeriodString = SwellPeriod.getText().toString();
        TideString = Tide.getText().toString();
        SpotNameString = SpotName.getText().toString();

        if(!SwellHeightString.isEmpty() && !SwellPeriodString.isEmpty() && !TideString.isEmpty()){
            // Int values of
            SwellHeightInt = parseInt(SwellHeightString);
            SwellPeriodInt = parseInt(SwellPeriodString);
            TideInt = parseInt(TideString);
        }
    }

    public void addConditions(){
        Conditions condition = new Conditions(SwellHeightInt, SwellPeriodInt, SwellDirectionString, TideInt, SpotNameString);
        ConditionsAccessPoint.insert(condition);
    }

    public void deleteCondition(){
        Conditions SearchCondition = ConditionsAccessPoint.getConditionsBySpot(SpotNameString);
        ConditionsAccessPoint.delete(SearchCondition);
        Toast.makeText(this, "Conditions for " + SpotNameString + " Deleted", Toast.LENGTH_SHORT).show();
    }


    // Menu item on create
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }

    // Menu item log out functionality back
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.sub_item_log_out:
                Toast.makeText(this, "Clicked Log out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EditConditions.this, MainActivity.class);
                startActivity(intent);
                //TODO create Logout Method
                return true;
            case R.id.sub_item_back:
                Toast.makeText(this, "Clicked back to last page", Toast.LENGTH_SHORT).show();
                Intent intent_one = new Intent(EditConditions.this, HomePage.class);
                startActivity(intent_one);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public static Intent intentFactory (Context context) {
        return new Intent(context, EditConditions.class);
    }

}