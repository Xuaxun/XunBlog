package com.xun.dao;

import com.xun.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    public User getUser(@Param("username") String username, @Param("password") String password);

}
