package com.jiuye.utils;

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
        String method = req.getParameter("method");
        Class<? extends BaseServlet> aClass = this.getClass();
        try {
            Method method1 = aClass.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            method1.invoke(aClass.newInstance(),req,resp);
        } catch (Exception e) {
              e.printStackTrace();
        }
    }
}

