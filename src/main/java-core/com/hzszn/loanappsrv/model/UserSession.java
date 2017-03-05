package com.hzszn.loanappsrv.model;

/**
 * Created by jhhuang on 17-3-5
 * QQ:781913268
 * Description：xxx
 */
public class UserSession
{
    private static ThreadLocal<UserSession> sessionHolder = new ThreadLocal<UserSession>();

    private Integer userId;

    public static UserSession getCurrent() {
        return sessionHolder.get();
    }

    public static void setCurrent(UserSession userSession) {
        sessionHolder.set(userSession);
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
