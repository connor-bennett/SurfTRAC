package com.example.surftrac.DB;

import androidx.room.TypeConverter;
public class BoolConveter {

    @TypeConverter
    public int ConvertBoolToInt(boolean value){
        if(value){
            return 1;
        }else{
            return 0;
        }
    }

    @TypeConverter
    public boolean ConvertIntToBool(int value){
        return value == 1;
    }

}
