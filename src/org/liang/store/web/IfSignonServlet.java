package org.liang.store.web;

import org.liang.store.bean.sign;
import org.liang.store.service.SignService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by liangx on 2016-03-23.
 */
public class IfSignonServlet extends HttpServlet {


    private boolean authenticated;

    private static final String SUCCESS = "/WEB-INF/jsp/catalog/Main.jsp";
    private static final String FAIL = "/WEB-INF/jsp/account/SignonForm.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        sign signNow = new sign(username,password);

        SignService signService = new SignService();

        if (signService.login(signNow))
        {
            authenticated = true;
            session.setAttribute("accountBean", this);
            session.setAttribute("authenticated", authenticated);
            session.setAttribute("userName",username);
            request.getRequestDispatcher(SUCCESS).forward(request,response);
        }else {
            String error = "用户名或密码错误";
            request.setAttribute("error",error);
            request.getRequestDispatcher(FAIL).forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
