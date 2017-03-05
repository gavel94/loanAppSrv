package com.hzszn.loanappsrv.constant;

/**
 * Created by jhhuang on 17-3-5
 * QQ:781913268
 * Description：xxx
 */
public enum AuthHeaderEnum
{
    /**
     * token信息
     */
    X_LOAN_TOKEN("x-loan-token"),
    X_LOAN_PLATFORM("x-loan-platform"),
    ;

    private String value;

    AuthHeaderEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
