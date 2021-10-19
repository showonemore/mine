package com.jiuye.service;

import com.jiuye.dao.UserDao;
import com.jiuye.entity.User;

public class UserService {
    UserDao dao= new UserDao();
    public User login(String username, String password){
        return dao.findUserByUsernameAndPassWord(username, password);
    }
}
