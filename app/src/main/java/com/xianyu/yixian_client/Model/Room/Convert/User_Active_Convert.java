package com.xianyu.yixian_client.Model.Room.Convert;

import androidx.room.TypeConverter;

import com.xianyu.yixian_client.Model.Enums;

import java.util.Date;

/**
 * @ProjectName: YiXian_Client
 * @Package: com.xianyu.yixian_client.Model.Room.Convert.Enums
 * @ClassName: User_Active_Convert
 * @Description: java类作用描述
 * @Author: Jianxian
 * @CreateDate: 2020/12/19 23:52
 * @UpdateUser: Jianxian
 * @UpdateDate: 2020/12/19 23:52
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class User_Active_Convert {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
    @TypeConverter
    public static String EnumstoString(Enums.User_Active value){
        switch (value){
            case Leisure:return "Leisure";
            case Gaming:return "Gaming";
            default:break;
        }
        return null;
    }
    @TypeConverter
    public static Enums.User_Active StringtoEnums(String value){
        switch (value){
            case "Leisure":return Enums.User_Active.Leisure;
            case "Gaming":return Enums.User_Active.Gaming;
            default:break;
        }
        return null;
    }
}
