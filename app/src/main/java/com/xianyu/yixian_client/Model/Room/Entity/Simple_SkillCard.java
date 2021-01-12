package com.xianyu.yixian_client.Model.Room.Entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.xianyu.yixian_client.Model.Room.Convert.User_Active_Convert;

import kotlin.text.UStringsKt;

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
    public int getNum1;
    public int getNum2;
    public int getNum3;
    public int getNum4;
    public int getNum5;
    public int getNum6;
    public int getNum7;
    public int getNum8;
    @PrimaryKey
    @NonNull
    private String name;
    private int level;
    private int amount;
    private String  description;
    private int num1;
    private int num2;
    private int num3;
    private int num4;
    private int num5;
    private int num6;
    private int num7;
    private int num8;

    public void setDescription(String description) { this.description = description; }
    public void setNum1(int num1) { this.num1 = num1; }
    public void setNum2(int num2) { this.num2 = num2; }
    public void setNum3(int num3) { this.num3 = num3; }
    public void setNum4(int num4) { this.num4 = num4; }
    public void setNum5(int num5) { this.num5 = num5; }
    public void setNum6(int num6) { this.num6 = num6; }
    public void setNum7(int num7) { this.num7 = num7; }
    public void setNum8(int num8) { this.num8 = num8; }
    public String getDescription() { return description; }
    public int getNum1() { return num1; }
    public int getNum2() { return num2; }
    public int getNum3() { return num3; }
    public int getNum4() { return num4; }
    public int getNum5() { return num5; }
    public int getNum6() { return num6; }
    public int getNum7() { return num7; }
    public int getNum8() { return num8; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

    public Simple_SkillCard(@NonNull String name, String description, int num1, int num2, int num3, int num4, int num5, int num6, int num7, int num8) {
        this.name = name;
        this.description = description;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.num5 = num5;
        this.num6 = num6;
        this.num7 = num7;
        this.num8 = num8;
    }

}
