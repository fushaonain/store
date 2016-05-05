package org.liang.store.service;

import org.liang.store.bean.Account;
import org.liang.store.bean.Sign;
import org.liang.store.persistence.Impl.RegisterDAOImpl;
import org.liang.store.persistence.RegisterDAO;

/**
 * Created by liangx on 2016-03-24.
 */
public class RegisterService {

    private RegisterDAO registerDAO;

    public RegisterService() {
        this.registerDAO = new RegisterDAOImpl();
    }

    public void register(Account account,Sign sign_now){
        registerDAO.ResertSignon(sign_now);
        registerDAO.ResertAccount(account);
        registerDAO.ResertProfile(account);
    }
}
