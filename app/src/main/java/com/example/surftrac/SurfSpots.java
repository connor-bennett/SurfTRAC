package com.example.surftrac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Entity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class SurfSpots extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surf_spots);
    }

    public static Intent intentFactory (Context context) {
        return new Intent(context, SurfSpots.class);
    }

    public static Intent intentFactory(Context context, int userId){
        Intent intent = new Intent(context, SurfSpots.class);
        // TODO I don't think I need this: intent.putExtra("userId", userId);
        return intent;
    }

}