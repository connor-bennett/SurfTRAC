package com.example.surftrac.table_objects;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.surftrac.DB.AppDataBase;

@Entity(tableName = AppDataBase.USER_TABLE)
public class User {

    @PrimaryKey(autoGenerate = true)
    private int mUserId;
    private String mPassword;
    private String mUsername;
    private boolean mIsAdmin;

    public User(int userId, String username, boolean isAdmin, String password) {
        mUserId = userId;
        mPassword = password;
        mUsername = username;
        this.mIsAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "mUserId=" + mUserId +
                ", mUsername='" + mUsername + '\'' +
                ", mIsAdmin=" + mIsAdmin +
                ", password=" + mPassword +
                '}';
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public boolean isAdmin() {
        return mIsAdmin;
    }

    public void setAdmin(boolean admin) {
        mIsAdmin = admin;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }
}
