package com.mofei.boke.dao.daoImpl;

import com.mofei.boke.bean.User;
import com.mofei.boke.dao.UserDao;
import com.mofei.boke.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author mofeiske
 * @Description: ${todo}
 * @Date: Create in 2019/4/23 17:11
 */

@Repository
public class UserDaoImpl implements UserDao {


    @Autowired
    UserRepository userRepository;

    @Override
    public User saveOrUpdateUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getOne(id);

    }

    @Override
    public List<User> listUsers() {
        System.out.println(userRepository.findAll());
        return userRepository.findAll();

    }
}
