package org.liang.store.service;

import org.liang.store.bean.Sign;
import org.liang.store.persistence.Impl.ifSignonImpl;
import org.liang.store.persistence.Signon;

/**
 * Created by liangx on 2016-03-23.
 */
public class SignService {

    private Signon signon;

    public SignService() {
        signon = new ifSignonImpl();
    }

    public boolean login(Sign sign){
        if(signon.ifSignon(sign) != null){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean ifExist(String username){
        if(signon.ifExistUsername(username) != null){
            return true;
        }
        else {
            return false;
        }
    }


}
