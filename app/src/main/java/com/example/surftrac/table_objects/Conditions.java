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
    int mIdealSwellDirection;
    int mIdealTide;
    int mUserId;
    String mSpotName;

    public Conditions(int idealSwellHeight, int idealSwellPeriod, int idealSwellDirection, int idealTide, int userId, String spotName) {
        mIdealSwellHeight = idealSwellHeight;
        mIdealSwellPeriod = idealSwellPeriod;
        mIdealSwellDirection = idealSwellDirection;
        mIdealTide = idealTide;
        mUserId = userId;
        mSpotName = spotName;
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

    public int getIdealSwellDirection() {
        return mIdealSwellDirection;
    }

    public void setIdealSwellDirection(int idealSwellDirection) {
        mIdealSwellDirection = idealSwellDirection;
    }

    public int getIdealTide() {
        return mIdealTide;
    }

    public void setIdealTide(int idealTide) {
        mIdealTide = idealTide;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    public String getSpotName() {
        return mSpotName;
    }

    public void setSpotName(String spotName) {
        mSpotName = spotName;
    }
}