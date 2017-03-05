package com.hzszn.loanappsrv.orm.dao.impl;

import com.hzszn.loanappsrv.orm.BaseDao;
import com.hzszn.loanappsrv.orm.dao.facade.UserMapper;
import com.hzszn.loanappsrv.orm.pojo.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * Created by jhhuang on 17-3-5
 * QQ:781913268
 * Description：xxx
 */
@Repository
@Primary
public class UserMapperImpl extends BaseDao implements UserMapper
{

    public int deleteByPrimaryKey(Integer id)
    {
        return super.getSqlSession().getMapper(UserMapper.class).deleteByPrimaryKey(id);
    }

    public int insert(User record)
    {
        return super.getSqlSession().getMapper(UserMapper.class).insert(record);
    }

    public int insertSelective(User record)
    {
        return super.getSqlSession().getMapper(UserMapper.class).insertSelective(record);
    }

    public User selectByPrimaryKey(Integer id)
    {
        return super.getSqlSession().getMapper(UserMapper.class).selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(User record)
    {
        return super.getSqlSession().getMapper(UserMapper.class).updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(User record)
    {
        return super.getSqlSession().getMapper(UserMapper.class).updateByPrimaryKey(record);
    }
}
