package com.example.surftrac;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
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
            default:
                return super.onOptionsItemSelected(item);
        }
    }


//
//    public static Intent intentFactory(Context context, int userId){
//        Intent intent = new Intent(context, HomePage.class);
//        // TODO I don't think I need this: intent.putExtra("userId", userId);
//        return intent;
//    }

}