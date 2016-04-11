package org.liang.store.web;

import org.liang.store.bean.Account;
import org.liang.store.service.AccountService;
import org.liang.store.service.SignService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by liangx on 2016-04-10.
 */
public class UsernameIsExistServletServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        SignService service = new SignService();

        response.setContentType("text/xml");
        PrintWriter out =  response.getWriter();

        if(service.ifExist(username)){
            out.println("<msg>Exist</msg>");
        }else{
            out.println("<msg>NotExist</msg>");
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
