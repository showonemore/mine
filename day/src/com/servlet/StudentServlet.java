package com.servlet;

import com.entity.Student;
import com.entity.resultVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.StudentService;
import com.utils.BaseServlet;
import com.utils.PageBean;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/stu")
public class StudentServlet extends BaseServlet {
    StudentService service = new StudentService();
    public void add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        Student student = new Student();
        BeanUtils.populate(student,map);
        String[] hobbies = request.getParameterValues("hobby");
        student.setHobby(Arrays.toString(hobbies));
        int row = service.register(student);
        ObjectMapper mapper = new ObjectMapper();
        resultVo vo;
        if (row>0){
//            response.sendRedirect(request.getContextPath()+"/stu?method=findPages");
            vo = new resultVo(200,"添加成功",null);
        }else {
//            throw new RuntimeException("新增学生失败");
            vo =new resultVo(500,"添加失败",null);
        }
        String json = mapper.writeValueAsString(vo);
        response.getWriter().print(json);
    }

    public void findPages(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        PageBean pb = service.findPages(currentPage,pageSize,name,sex);
        //创建json工具类
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(pb);
        response.getWriter().print(json);
//        request.setAttribute("pb",pb);
//        request.setAttribute("name",name);
//        request.getRequestDispatcher("/jsp/list.jsp").forward(request,response);
    }
    public void del(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ids = request.getParameter("ids");
        int row= service.delAll(ids);
        if (row>0){
            response.sendRedirect(request.getContextPath()+"/stu?method=findPages");
        }else{
            throw new RuntimeException("批量删除失败");
        }
    }
    public void findStu(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String id = request.getParameter("id");
        //调用业务
        Student stu= service.findStudent(id);
        //相应处理结果
        request.setAttribute("stu",stu);
        request.getRequestDispatcher("/jsp/edit.jsp").forward(request,response);
    }
    public void updateStu(HttpServletRequest request,HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        Student stu = new Student();
        BeanUtils.populate(stu,map);
        String[] hobbies = request.getParameterValues("hobby");
        stu.setHobby(Arrays.toString(hobbies));
        int row=service.updateStu(stu);
        if (row > 0){
            response.sendRedirect(request.getContextPath()+"/stu?method=findPages");
        }else {
            throw new RuntimeException("修改学生信息失败");
        }
    }
}
