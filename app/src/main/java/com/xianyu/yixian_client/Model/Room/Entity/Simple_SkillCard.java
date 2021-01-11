package com.xianyu.yixian_client.Model.Room.Entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.xianyu.yixian_client.Model.Room.Convert.User_Active_Convert;

/**
 * @ProjectName: YiXian_Client
 * @Package: com.xianyu.yixian_client.Model
 * @ClassName: Simple_SkillCard
 * @Description: java类作用描述
 * @Author: Jianxian
 * @CreateDate: 2020/12/17 16:06
 * @UpdateUser: Jianxian
 * @UpdateDate: 2020/12/17 16:06
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Entity(tableName = "skill_cards")
public class Simple_SkillCard {
    @PrimaryKey
    @NonNull
    private String name;
    private int level;
    private int amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Simple_SkillCard(@NonNull String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
}
