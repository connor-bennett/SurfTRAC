package com.example.surftrac.Page_Interactions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.surftrac.R;

public class SurfSpotConditions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surf_spots);
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

}