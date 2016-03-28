package org.liang.store.bean;

/**
 * Created by liangx on 2016-03-23.
 */
public class sign {

    private String username;
    private String password;

    public sign(String username, String password) {
        this.username = username;
        this.password = password;
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


}
