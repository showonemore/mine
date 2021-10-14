package com.service;

import com.dao.StudentDao;
import com.entity.Student;
import com.utils.PageBean;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    StudentDao dao = new StudentDao();
    public int register(Student student) {
        return dao.save(student);
    }

    public PageBean findPages(String currentPage, String pageSize, String name, String sex) {
        //设置默认页码
        PageBean pb = new PageBean();
        if (currentPage ==null || currentPage.trim().equals("")){
            currentPage= "1";
        }
        if (pageSize ==null || pageSize.trim().equals("")){
            pageSize= "3";
        }
        int cpage = Integer.parseInt(currentPage);
        int size = Integer.parseInt(pageSize);
        pb.setCurrentPage(cpage);
        pb.setPageSize(size);
        StringBuffer sb = new StringBuffer("select * from student where 1=1 ");
        ArrayList<Object> params = new ArrayList<>();
        if (name!=null && !name.trim().equals("")){
            sb.append(" and name like ?");
            params.add("%" + name + "%");
        }
        if (sex!=null && !sex.trim().equals("") && !sex.equals("-1")){
            sb.append(" and sex = ?  ");
            params.add(sex);
        }
        int totalCount = dao.findCount(sb.toString(),params.toArray());
        pb.setTotalCount(totalCount);
        int totalPage = totalCount%size==0?totalCount/size:totalCount/size+1;
        pb.setTotalPage(totalPage);
        List<Student> list = dao.findListByLimit(sb,params,cpage,size);
        pb.setList(list);
        return pb;
    }

    public int delAll(String ids) {
        return dao.DelById(ids);
    }

    public Student findStudent(String id) {
        return dao.findStudentById(id);
    }

    public int updateStu(Student stu) {
        return dao.updateStudentById(stu);
    }
}
