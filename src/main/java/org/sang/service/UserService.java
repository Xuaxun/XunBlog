package org.sang.service;

import org.sang.dao.UserDao;
import org.sang.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public boolean login(String username,String password){
        User user = userDao.getUser(username,password);
        if (user == null){
            return false;
        }else{
            return true;
        }
    }
}
