package org.liang.store.persistence;

import org.liang.store.bean.Sign;

/**
 * Created by liangx on 2016-03-23.
 */
public interface Signon {

    Sign ifSignon(Sign sign);
    String ifExistUsername(String username);
}
