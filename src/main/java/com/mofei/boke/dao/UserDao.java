package com.mofei.boke.dao;

import com.mofei.boke.bean.User;

import java.util.List;

/**
 * @Description: 用户的资源接口
 */
public interface UserDao {

    //创建或者修改用户
    User saveOrUpdateUser(User user);

    //删除用户
    void deleteUser(int id);

    //查询用户id
    User getUserById(int id);
    
    //获取用户列表
    List<User> listUsers();

}
