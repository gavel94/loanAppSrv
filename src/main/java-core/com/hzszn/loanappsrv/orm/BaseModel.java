package com.hzszn.loanappsrv.orm;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by jhhuang on 17-3-5
 * QQ:781913268
 * Description：BaseModel
 */
public class BaseModel implements Serializable
{
    private Integer id;     //唯一ID
    private Integer version;        //数据版本号
    private Long stateflag;      //数据状态
    private LocalDateTime createAt;         //创建时间
    private LocalDateTime updateAt;         //更新时间
    private String remark;          //数据备注

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    public Long getStateflag()
    {
        return stateflag;
    }

    public void setStateflag(Long stateflag)
    {
        this.stateflag = stateflag;
    }

    public LocalDateTime getCreateAt()
    {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt)
    {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt()
    {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt)
    {
        this.updateAt = updateAt;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }
}
