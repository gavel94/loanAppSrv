package com.hzszn.loanappsrv.service.impl;

import com.hzszn.loanappsrv.orm.dao.facade.UserMapper;
import com.hzszn.loanappsrv.orm.pojo.User;
import com.hzszn.loanappsrv.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Created by jhhuang on 17-3-5
 * QQ:781913268
 * Description：xxx
 */
@Service
@Primary
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    public int insertUser(User user) throws Exception
    {
        return userMapper.insert(user);
    }

    public User findUserById(int id) throws Exception
    {
        return userMapper.selectByPrimaryKey(id);
    }
}
