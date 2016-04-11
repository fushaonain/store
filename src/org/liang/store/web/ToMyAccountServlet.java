package org.liang.store.web;

import org.liang.store.bean.Account;
import org.liang.store.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by liangx on 2016-04-03.
 */
public class ToMyAccountServlet extends HttpServlet {
    private static final String MYACCOUNT = "/WEB-INF/jsp/account/EditAccountForm.jsp";
    private Account account;
    private AccountService accountService = new AccountService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("userName");

        account = accountService.selectAccountBYUserId(username);

        session.setAttribute("account",account);
        request.getRequestDispatcher(MYACCOUNT).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
