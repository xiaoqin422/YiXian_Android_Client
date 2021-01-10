package com.xianyu.yixian_client.Model.Room.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.xianyu.yixian_client.Model.Enums;

import java.math.BigInteger;

/**
 * @ProjectName: YiXian_Client
 * @Package: com.xianyu.yixian_client.Model.Room.Entity
 * @ClassName: SkillCard
 * @Description: java类作用描述
 * @Author: Jianxian
 * @CreateDate: 2021/1/8 20:25
 * @UpdateUser: Jianxian
 * @UpdateDate: 2021/1/8 20:25
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Entity(tableName = "skillcards")
public class SkillCard {
    @PrimaryKey
    long id;//卡牌ID
    String name;//卡牌名字
    String description;//卡牌描述
    int mp;//释放卡牌所需消耗的仙气值
    int probability;//卡牌觉醒的概率
    int auxiliary_hp;//己方HP效果
    int auxiliary_mp;//己方MP效果
    int enemy_hp;//敌人HP效果
    int enemy_mp;//敌人MP效果
    long author_id;//作者ID
    boolean is_magic;//是否魔法类
    boolean is_physics;//是否物理类
    boolean is_cure;//是否治疗类
    boolean is_attack;//是否攻击类
    boolean is_eternal;//是否永恒类
    long update;//卡牌最新版本
    int max_enemy;//最大锁定敌人数
    int max_auxiliary;//最大锁定友军数
}
