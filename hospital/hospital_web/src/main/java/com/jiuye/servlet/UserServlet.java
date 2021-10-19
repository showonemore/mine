package com.jiuye.servlet;

import com.jiuye.entity.User;
import com.jiuye.service.UserService;
import com.jiuye.utils.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends BaseServlet {
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService service = new UserService();
        User user = service.login(username, password);
        if (user!=null){
            //登录成功
            request.getSession().setAttribute("user",user);
            response.sendRedirect(request.getContextPath()+"/html/success.jsp");
        }else {
            request.setAttribute("msg","用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
