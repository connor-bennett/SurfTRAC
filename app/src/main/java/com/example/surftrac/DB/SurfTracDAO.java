package com.example.surftrac.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.surftrac.User;

@Dao
public interface SurfTracDAO {
    @Insert
    void insert(User...users);
    @Update
    void update(User...users);
    @Delete
    void delete(User user);


}
