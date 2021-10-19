package com.jiuye.dao;

import com.jiuye.entity.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    ComboPooledDataSource dataSource= new ComboPooledDataSource();
    QueryRunner qr= new QueryRunner(dataSource);
    public User findUserByUsernameAndPassWord(String username,String password){
        String sql ="select * from user where username=? and password=?";
        try {
            return qr.query(sql, new BeanHandler<User>(User.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
