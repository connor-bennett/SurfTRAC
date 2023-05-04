package com.example.surftrac.table_objects;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.surftrac.DB.AppDataBase;

import java.util.Date;

@Entity(tableName = AppDataBase.Surf_LOG_TABLE)
public class Surf_Log {

    @PrimaryKey(autoGenerate = true)
    private int mLogId;
    private int mSwellHeight;
    private int mSwellPeriod;
    private String mSwellDirection;
    private int mTide;
    private Date mDate;
    private int mUserId;

    public Surf_Log(int swellHeight, int swellPeriod, String swellDirection, int tide, int userId) {
        mSwellHeight = swellHeight;
        mSwellPeriod = swellPeriod;
        mSwellDirection = swellDirection;
        mTide = tide;
        mDate = new Date();
        mUserId = userId;
    }

    public int getLogId() {
        return mLogId;
    }

    public void setLogId(int logId) {
        mLogId = logId;
    }

    public int getSwellHeight() {
        return mSwellHeight;
    }

    public void setSwellHeight(int swellHeight) {
        mSwellHeight = swellHeight;
    }

    public int getSwellPeriod() {
        return mSwellPeriod;
    }

    public void setSwellPeriod(int swellPeriod) {
        mSwellPeriod = swellPeriod;
    }

    public String getSwellDirection() {
        return mSwellDirection;
    }

    public void setSwellDirection(String swellDirection) {
        mSwellDirection = swellDirection;
    }

    public int getTide() {
        return mTide;
    }

    public void setTide(int tide) {
        mTide = tide;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

}