package com.mofei.boke.repository.repositoryImpl;

import com.mofei.boke.bean.User;
import com.mofei.boke.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author mofeiske
 * @Description: ${todo}
 * @Date: Create in 2019/4/23 17:11
 */


@Repository
public class UserRepositoryImpl implements UserRepository{

    //初始化值等于1,每次获取值加1
    private static AtomicLong counter = new AtomicLong();

    //存储用户的信息
    private final ConcurrentMap<Long,User> userMap = new ConcurrentHashMap<>();

    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        if (id == null) {
            id=counter.incrementAndGet();//获取值,加一
            user.setId(id);
        }
        System.out.println(user);
        this.userMap.put(id,user);
        return user;
    }

    @Override
    public void deleteUser(long id) {
        this.userMap.remove(id);
    }

    @Override
    public User getUserById(long id) {
        return this.userMap.get(id);
    }

    @Override
    public List<User> listUsers() {
        return new ArrayList<User>(this.userMap.values());
    }
}
