package org.liang.store.persistence;

import org.liang.store.bean.Account;
import org.liang.store.bean.sign;

/**
 * Created by liangx on 2016-04-03.
 */
public interface UpdateAccountDAO {

    void updateAccount(Account account);
    void updateSignon(sign sign_now);
    void updateProfilr(Account account);
}
