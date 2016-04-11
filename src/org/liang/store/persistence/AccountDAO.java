package org.liang.store.persistence;

import org.liang.store.bean.Account;

/**
 * Created by liangx on 2016-03-29.
 */
public interface AccountDAO {

    Account getAccountBy(String userId);
    //Account usernameIsExist(String username);
}
