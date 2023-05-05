package com.example.surftrac.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.surftrac.table_objects.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    void insert(User...users);

    @Delete
    void delete(User user);

    @Update
    void update(User...users);

    @Query("SELECT * FROM " + AppDataBase.USER_TABLE)
    List<User> getAllUsers();

    @Query("SELECT * FROM " + AppDataBase.USER_TABLE + " WHERE mUserName = :userName")
    User getUserByUserName(String userName);

    @Query("SELECT * FROM " + AppDataBase.USER_TABLE + " WHERE mUserId = :userId")
    User getUserByUserId(int userId);

}
