package com.example.surftrac.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.surftrac.table_objects.Conditions;
import com.example.surftrac.table_objects.Surf_Log;
import com.example.surftrac.table_objects.User;

@TypeConverters({DateConverter.class, BoolConveter.class})
@Database(entities = {User.class, Surf_Log.class, Conditions.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public static final String DATABASE_NAME = "SURFTRAC_.db";
    public static final String USER_TABLE = "user_table";
    public static final String LOG_TABLE = "surf_Log_table";
    public static final String CONDITIONS_TABLE = "conditions_table";

    private static volatile AppDataBase instance;
    private static final Object LOCK = new Object();

    public SurfTracDAO getSurfTracDAO;


    public static AppDataBase getInstance(Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class,
                            DATABASE_NAME).build();
                }
            }
        }
        return instance;
    }

}
