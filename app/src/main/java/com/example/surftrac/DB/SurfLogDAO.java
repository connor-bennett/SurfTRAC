package com.example.surftrac.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.surftrac.table_objects.Surf_Log;

import java.util.List;

@Dao
public interface SurfLogDAO {
    @Insert
    void insert(Surf_Log...surfLogs);
    @Update
    void update(Surf_Log...surfLogs);
    @Delete
    void delete(Surf_Log surf_log);

    @Query("SELECT * FROM " + AppDataBase.Surf_LOG_TABLE)
    List<Surf_Log> getAllSurfLogs();

    @Query("SELECT * FROM " + AppDataBase.Surf_LOG_TABLE + " WHERE mLogId = :logId")
    List<Surf_Log> getSurfLogById(int logId);

    @Query("SELECT * FROM " + AppDataBase.Surf_LOG_TABLE + " WHERE mSpotName = :spotName")
    List<Surf_Log> getSurfLogByLocation(String spotName);

}
