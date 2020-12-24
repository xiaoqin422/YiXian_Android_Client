package com.xianyu.yixian_client.Model.Room.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
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
public interface UserDao {
    @Insert
    public void insert(User... arg);

    @Update
    public void updateUser(User... user);

    @Delete
    public void deleteUser(User... user);

    @Query("SELECT * FROM users WHERE username = :username")
    public Single<User> queryUser(String username);
    @Query("SELECT * FROM users WHERE qQ = :qQ")
    public Single<List<User>> queryUser(long qQ);
    @Query("SELECT * FROM users")
    public Single<List<User>> queryUsers();
}
