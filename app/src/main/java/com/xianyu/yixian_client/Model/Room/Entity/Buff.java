package com.xianyu.yixian_client.Model.Room.Entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.xianyu.yixian_client.Model.Enums;

/**
 * @ProjectName: YiXian_Client
 * @Package: com.xianyu.yixian_client.Model.Room.Entity
 * @ClassName: Buff
 * @Description: java类作用描述
 * @Author: Jianxian
 * @CreateDate: 2021/1/8 21:23
 * @UpdateUser: Jianxian
 * @UpdateDate: 2021/1/8 21:23
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Entity(tableName = "buffs")
public class Buff {
    public enum Category { Freeze };
    @PrimaryKey
    long id;//状态ID
    int name;//状态名称
    int duration_Immediate;//效果持续时长
    int duration_Round;//效果持续回合
    int power;//能力
    Category category;//类型

}
