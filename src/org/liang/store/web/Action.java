package org.liang.store.web;

/**
 * Created by liangx on 2016-04-13.
 */
public interface Action {
    public static final String SUCCESS = "success";

    public static final String None = "none";

    public static final String ERROR = "error";

    public static final String INPUT = "input";

    public static final String LOGIN = "login";

    public String execute() throws Exception;

}
