package org.liang.store.service;

import org.liang.store.bean.Account;
import org.liang.store.bean.Sign;
import org.liang.store.persistence.AccountDAO;
import org.liang.store.persistence.Impl.AccountDAOImpl;
import org.liang.store.persistence.Impl.UpdateAccountDAOImpl;
import org.liang.store.persistence.UpdateAccountDAO;

/**
 * Created by liangx on 2016-04-03.
 */
public class AccountService {
    private AccountDAO accountDAO;
    private UpdateAccountDAO updateAccountDAO;

    public AccountService() {
        this.accountDAO = new AccountDAOImpl();
        updateAccountDAO = new UpdateAccountDAOImpl();
    }

    public boolean ifHaveAccount(String userID){
        if(accountDAO.getAccountBy(userID) == null){
            return false;
        }else{
            return true;
        }
    }
    public void update(Account account,Sign sign_now){
        updateAccountDAO.updateAccount(account);
        updateAccountDAO.updateProfilr(account);
        updateAccountDAO.updateSignon(sign_now);
    }

    public Account selectAccountBYUserId(String userId){
        Account account = accountDAO.getAccountBy(userId);
        return account;

    }
}
