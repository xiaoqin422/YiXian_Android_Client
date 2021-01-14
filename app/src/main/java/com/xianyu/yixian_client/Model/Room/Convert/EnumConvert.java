package com.xianyu.yixian_client.Model.Room.Convert;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.xianyu.yixian_client.Model.Room.Entity.User;

import java.util.ArrayList;

public class EnumConvert {
    @TypeConverter
    public String enumToString(Enum value){
        return value.toString();
    }
    @TypeConverter
    public Enum stringToEnum(String value){
        return Enum.valueOf(null,value);
    }
}
