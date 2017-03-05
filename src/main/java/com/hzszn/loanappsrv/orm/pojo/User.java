package com.hzszn.loanappsrv.orm.pojo;

import com.hzszn.loanappsrv.orm.BaseModel;
import java.io.Serializable;

public class User extends BaseModel implements Serializable {

    private String userName;

    private Integer age;

    private Integer sex;

    private static final long serialVersionUID = 1L;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}