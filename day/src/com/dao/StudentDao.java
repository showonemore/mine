package com.dao;

import com.entity.Student;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    ComboPooledDataSource dataSource =new ComboPooledDataSource();
    QueryRunner qr = new QueryRunner(dataSource);
    //添加学生信息
    public int save(Student s) {
        String sql ="insert into student values(null,?,?,?,?,?,?)";
        try {
           return qr.update(sql,s.getName(),s.getAge(),s.getSex(),s.getHobby(),s.getWork(),s.getSdesc());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }
    //查找信息总条数
    public int findCount(String sql, Object[] toArray) {
        try {
           return qr.query(sql,new BeanListHandler<Student>(Student.class),toArray).size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Student> findListByLimit(StringBuffer sb, ArrayList<Object> params, int cpage, int size) {
        sb.append(" limit ?,? ");
        int start = (cpage-1)*size;
        params.add(start);
        params.add(size);
        try {
            return qr.query(sb.toString(),new BeanListHandler<Student>(Student.class),params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int DelById(String ids) {
        String sql ="delete from student where id in("+ids+")";
        try {
            return  qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Student findStudentById(String id) {
        String sql = "select * from student where id =?";
        try {
            return qr.query(sql,new BeanHandler<Student>(Student.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateStudentById(Student stu) {
        String sql="update student set name=?,age=?,sex=?,hobby=?,work=?,sdesc=? where id=?";
        try {
          return  qr.update(sql,stu.getName(),stu.getAge(),stu.getSex(),stu.getHobby(),stu.getWork(),stu.getSdesc(),stu.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
