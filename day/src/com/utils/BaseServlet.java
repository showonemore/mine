package com.utils;

import com.sun.net.httpserver.HttpsServer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("UTF-8");
        //获取要执行的业务方法
        String method = req.getParameter("method");
        //获取当前类的字节码文件
        Class<? extends BaseServlet> aClass = this.getClass();
        try {
            //根据方法名和方法的参数类型去字节码文件中获取该方法
            Method m = aClass.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            //执行方法
            m.invoke(aClass.newInstance(),req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
