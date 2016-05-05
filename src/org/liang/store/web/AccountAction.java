package org.liang.store.web;

import com.opensymphony.xwork2.ActionContext;
import org.liang.store.bean.Account;
import org.liang.store.bean.Sign;
import org.liang.store.service.AccountService;

import java.util.Map;

/**
 * Created by liangx on 2016-04-13.
 */
public class AccountAction implements Action {
    private String username;
    private String password;

    private boolean authenticated;

    private Account account;
    private AccountService accountService = new AccountService();

    ActionContext context = ActionContext.getContext();
    Map session = context.getSession();
    @Override
    public String execute() throws Exception {
        username = (String) session.get("username");
        account = accountService.selectAccountBYUserId(username);

        return SUCCESS;
    }

    public String updateAccount() throws Exception{
        username = (String) session.get("username");
        password = (String) session.get("psaaword");
        Sign signNow = new Sign(username,password);
        accountService.update(account,signNow);

        return SUCCESS;

    }

    public String toCheckOut() throws Exception{
        username = (String) session.get("username");
        account = accountService.selectAccountBYUserId(username);

        return SUCCESS;
    }

    public String confimOrder() throws Exception{
        username = (String) session.get("username");
        account = accountService.selectAccountBYUserId(username);

        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
