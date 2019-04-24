package com.mofei.boke.repository;

import com.mofei.boke.bean.User;

import java.util.List;

/**
 * @Description: 用户的资源接口
 */
public interface UserRepository {

    //创建或者修改用户
    User saveOrUpdateUser(User user);

    //删除用户
    void deleteUser(long id);

    //查询用户id
    User getUserById(long id);

    //获取用户列表
    List<User> listUsers();

}
