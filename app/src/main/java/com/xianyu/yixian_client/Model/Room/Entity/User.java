package com.xianyu.yixian_client.Model.Room.Entity;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.xianyu.yixian_client.Model.Enums;
import com.xianyu.yixian_client.Model.Room.Convert.User_Active_Convert;
import com.xianyu.yixian_client.Model.Tcp.MsgToken;

import java.util.Date;
import java.util.HashMap;

/**
 * @ProjectName: YiXian_Client
 * @Package: com.xianyu.yixian_client.Model
 * @ClassName: User
 * @Description: java类作用描述
 * @Author: Jianxian
 * @CreateDate: 2020/12/16 15:05
 * @UpdateUser: Jianxian
 * @UpdateDate: 2020/12/16 15:05
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Entity(tableName = "users")
@TypeConverters({User_Active_Convert.class})
public class User
{
    @PrimaryKey
    @NonNull
    private String userName;
    private String nickName;
    private int upgrade_num=0;
    private int create_num=0;
    private int money = 0;


    private String passwords;
    private String information;
    private int battle_Count;//战斗场次
    private int exp;//经验
    private int balances;//金钱
    private int lv = 1;//等级
    private String title = "炼气";//称号
    private Enums.User_Active active = Enums.User_Active.Leisure;//玩家当前游戏状态
    private int kills;//击杀数
    private int deaths;//死亡数
    @Ignore
    private Date skillCards_Date;//技能卡版本
    @Ignore
    private Date registration_date;//注册时间
    public long qQ = -1;
    @Embedded
    private MsgToken msgToken;
    @Ignore
    private HashMap<String, Simple_SkillCard> repository_SkillCards = new HashMap<String, Simple_SkillCard>();//技能卡仓库
    @Ignore
    private HashMap<String, Simple_SkillCard> battle_SkillCards = new HashMap<String, Simple_SkillCard>();//备战的技能卡

    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public MsgToken getMsgToken() {
        return msgToken;
    }

    public void setMsgToken(MsgToken msgToken) {
        this.msgToken = msgToken;
    }



    public void setUpgrade_num(int upgrade_num) {
        this.upgrade_num = upgrade_num;
    }

    public void setCreate_num(int create_num) {
        this.create_num = create_num;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void setBattle_Count(int battle_Count) {
        this.battle_Count = battle_Count;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setBalances(int balances) {
        this.balances = balances;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setActive(Enums.User_Active active) {
        this.active = active;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void setSkillCards_Date(Date skillCards_Date) {
        this.skillCards_Date = skillCards_Date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }


    public void setRepository_SkillCards(HashMap<String, Simple_SkillCard> repository_SkillCards) {
        this.repository_SkillCards = repository_SkillCards;
    }

    public void setBattle_SkillCards(HashMap<String, Simple_SkillCard> battle_SkillCards) {
        this.battle_SkillCards = battle_SkillCards;
    }



    public void setQQ(long qQ) {
        this.qQ = qQ;
    }

    public long getQQ() {
        return qQ;
    }


    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", upgrade_num=" + upgrade_num +
                ", create_num=" + create_num +
                ", money=" + money +
                ", passwords='" + passwords + '\'' +
                ", information='" + information + '\'' +
                ", battle_Count=" + battle_Count +
                ", exp=" + exp +
                ", balances=" + balances +
                ", lv=" + lv +
                ", title='" + title + '\'' +
                ", active=" + active +
                ", kills=" + kills +
                ", deaths=" + deaths +
                ", skillCards_Date=" + skillCards_Date +
                ", registration_date=" + registration_date +
                ", qQ=" + qQ +
                ", msgToken=" + msgToken +
                ", repository_SkillCards=" + repository_SkillCards +
                ", battle_SkillCards=" + battle_SkillCards +
                '}';
    }

    public int getUpgrade_num() {
        return upgrade_num;
    }

    public int getCreate_num() {
        return create_num;
    }

    public int getMoney() {
        return money;
    }

    public String getInformation() {
        return information;
    }

    public int getBattle_Count() {
        return battle_Count;
    }

    public int getExp() {
        return exp;
    }

    public int getBalances() {
        return balances;
    }

    public int getLv() {
        return lv;
    }

    public String getTitle() {
        return title;
    }

    public Enums.User_Active getActive() {
        return active;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public HashMap<String, Simple_SkillCard> getRepository_SkillCards() {
        return repository_SkillCards;
    }

    public HashMap<String, Simple_SkillCard> getBattle_SkillCards() {
        return battle_SkillCards;
    }

    public Date getSkillCards_Date() {
        return skillCards_Date;
    }



}
