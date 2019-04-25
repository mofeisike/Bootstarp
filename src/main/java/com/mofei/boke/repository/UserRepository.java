package com.mofei.boke.repository;

import com.mofei.boke.bean.User;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * description: 编写一个Dao接口来操作实体类对应的数据表(Repository)
 * 统一接口实现repository.java
 */


//JpaRepository<T,ID extends Serializable> 可序列化的 传入主键

//继承JpaRepository来完成对数据库的操作
public interface UserRepository extends JpaRepository<User,Integer>{


}
