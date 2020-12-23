package com.xianyu.yixian_client.Model.Room.Entity;

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
public class Simple_SkillCard {
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
}
