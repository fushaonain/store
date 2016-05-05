package org.liang.store.web;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.liang.store.bean.Sign;
import org.liang.store.service.SignService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by liangx on 2016-04-11.
 */
public class SignAction implements Action{
    private SignService signService;

    private boolean authenticated;

    private SignAction signAction;

    private String username;
    private String password;
    private String accountBean;

    public SignAction() {
        this.signService = new SignService();
    }
    public String execute() throws Exception{
        return "input";
    }
    public String login() throws Exception{
        Sign sign = new Sign(username,password);
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        if (signService.login(sign)){
            authenticated = true;
            accountBean = "cunzai";
            session.setAttribute("accountBean", accountBean);
            session.setAttribute("authenticated", authenticated);
            session.setAttribute("username", username);
            session.setAttribute("psaaword",password);
            return "success";
        }else {

            String error = "用户名或密码错误";
            ActionContext context = ActionContext.getContext();
            Map request_one = (Map) context.get("request");
            request_one.put("error",error);
            return "input";
        }
    }

    public String signOut() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        session.invalidate();
        return SUCCESS;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public SignAction getSignAction() {
        return signAction;
    }

    public void setSignAction(SignAction signAction) {
        this.signAction = signAction;
    }

    public String getAccountBean() {
        return accountBean;
    }

    public void setAccountBean(String accountBean) {
        this.accountBean = accountBean;
    }
}

