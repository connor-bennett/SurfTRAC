package com.example.surftrac.table_objects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import android.os.Bundle;

import com.example.surftrac.DB.AppDataBase;

@Entity(tableName = AppDataBase.CONDITIONS_TABLE)
public class Conditions{
    @PrimaryKey(autoGenerate = true)

    int mIdealSwellHeight;
    int mIdealSwellPeriod;
    String mIdealSwellDirection;
    int mIdealTide;
    String mSpotName;

    public Conditions(int idealSwellHeight, int idealSwellPeriod, String idealSwellDirection, int idealTide, String spotName) {
        mIdealSwellHeight = idealSwellHeight;
        mIdealSwellPeriod = idealSwellPeriod;
        mIdealSwellDirection = idealSwellDirection;
        mIdealTide = idealTide;
        mSpotName = spotName;
    }

    @Override
    public String toString() {
        return "Location: " + mSpotName + "\n" +
                "Sewell Height: " + mIdealSwellHeight + "\n" +
                "Swell Direction: " + mIdealSwellDirection +"\n" +
                "Swell Period: " + mIdealSwellPeriod + "\n" +
                "Tide: " + mIdealTide + "\n" + "------------------" +"\n";
    }

    public int getIdealSwellHeight() {
        return mIdealSwellHeight;
    }

    public void setIdealSwellHeight(int idealSwellHeight) {
        mIdealSwellHeight = idealSwellHeight;
    }

    public int getIdealSwellPeriod() {
        return mIdealSwellPeriod;
    }

    public void setIdealSwellPeriod(int idealSwellPeriod) {
        mIdealSwellPeriod = idealSwellPeriod;
    }

    public String getIdealSwellDirection() {
        return mIdealSwellDirection;
    }

    public void setIdealSwellDirection(String idealSwellDirection) {
        mIdealSwellDirection = idealSwellDirection;
    }

    public int getIdealTide() {
        return mIdealTide;
    }

    public void setIdealTide(int idealTide) {
        mIdealTide = idealTide;
    }

    public String getSpotName() {
        return mSpotName;
    }

    public void setSpotName(String spotName) {
        mSpotName = spotName;
    }
}