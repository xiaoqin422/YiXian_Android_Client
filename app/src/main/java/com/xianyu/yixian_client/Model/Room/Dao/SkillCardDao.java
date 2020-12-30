package com.xianyu.yixian_client.Model.Room.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.xianyu.yixian_client.Model.Room.Entity.Simple_SkillCard;
import com.xianyu.yixian_client.Model.Room.Entity.User;

import java.util.List;

import io.reactivex.Single;


/**
 * @ProjectName: YiXian_Client
 * @Package: com.xianyu.yixian_client.Model.Room.Dao
 * @ClassName: UserDao
 * @Description: java类作用描述
 * @Author: Jianxian
 * @CreateDate: 2020/12/19 22:38
 * @UpdateUser: Jianxian
 * @UpdateDate: 2020/12/19 22:38
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Dao
public interface SkillCardDao {
    @Insert
    public void insert(Simple_SkillCard... simple_skillCards);

    @Update
    public void update(Simple_SkillCard... simple_skillCards);

    @Delete
    public void delete(Simple_SkillCard... simple_skillCards);

    @Query("SELECT * FROM skill_cards WHERE name = :name")
    public Single<Simple_SkillCard> query(String name);

    @Query("SELECT * FROM skill_cards")
    public Single<List<Simple_SkillCard>> query();
}
