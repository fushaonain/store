package org.liang.store.persistence;

import org.liang.store.bean.Account;
import org.liang.store.bean.Sign;

/**
 * Created by liangx on 2016-03-24.
 */
public interface RegisterDAO {

    void ResertSignon(Sign signNow);
    void ResertAccount(Account account);
    void ResertProfile(Account account);
}
