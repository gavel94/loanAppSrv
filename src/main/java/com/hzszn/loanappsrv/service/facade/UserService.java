package com.hzszn.loanappsrv.service.facade;

import com.hzszn.loanappsrv.orm.pojo.User;

/**
 * Created by jhhuang on 17-3-5
 * QQ:781913268
 * Description：xxx
 */
public interface UserService
{
    int insertUser(User user) throws Exception;

    User findUserById(int id) throws Exception;
}
