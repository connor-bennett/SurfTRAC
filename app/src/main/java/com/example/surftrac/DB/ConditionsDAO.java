package com.example.surftrac.DB;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.surftrac.table_objects.Conditions;
import com.example.surftrac.table_objects.User;

import java.util.List;


@Dao
public interface ConditionsDAO {

    @Insert
    void insert(Conditions...conditions);

    @Delete
    void delete(Conditions...condition);

    @Update
    void update(Conditions...conditions);

    @Query("SELECT * FROM " + AppDataBase.CONDITIONS_TABLE)
    List<Conditions> getAllConditions();

    @Query("SELECT * FROM " + AppDataBase.CONDITIONS_TABLE + " WHERE mSpotName = :spotName")
    Conditions getConditionsBySpot(String spotName);

    @Query("SELECT * FROM " + AppDataBase.CONDITIONS_TABLE + " WHERE mIdealSwellDirection = :idealSwellDirection")
    Conditions getConditionsBySwellDirection(String idealSwellDirection);

}
