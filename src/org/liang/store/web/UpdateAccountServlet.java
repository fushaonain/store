package org.liang.store.web;

import org.liang.store.bean.Account;
import org.liang.store.bean.sign;
import org.liang.store.service.AccountService;
import org.liang.store.service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liangx on 2016-04-03.
 */
public class UpdateAccountServlet extends HttpServlet {
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String country = request.getParameter("country");
        String languagePreference = request.getParameter("languagePreference");
        String favouriteCategoryId = request.getParameter("account.favouriteCategoryId");
        String listOption = request.getParameter("listOption");
        String bannerOption = request.getParameter("bannerOption");
        boolean one;
        boolean two;
        if(listOption == null){
            one = false;
        }else {
            one = true;
        }
        if (bannerOption == null){
            two = false;
        }else {
            two = true;
        }

        Account account = new Account(username,password,firstName,lastName,email,
                address1,address2,city,state,zip,country,phone,languagePreference,
                favouriteCategoryId,one,two);
        AccountService accountService = new AccountService();
        sign signNow = new sign(username,password);
        accountService.update(account,signNow);
        request.getRequestDispatcher(MAIN).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
