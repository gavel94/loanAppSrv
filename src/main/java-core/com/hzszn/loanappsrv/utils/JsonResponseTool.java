package com.hzszn.loanappsrv.utils;

import com.hzszn.loanappsrv.constant.ResponseCodeEnum;
import com.hzszn.loanappsrv.model.CommonResponse;

/**
 * Created by jhhuang on 17-3-5
 * QQ:781913268
 * Description：xxx
 */
public abstract class JsonResponseTool
{
    /**
     * 通用成功返回消息
     *
     * @param data
     * @return
     */
    public static CommonResponse success(Object data) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(ResponseCodeEnum.SUCCESS.getValue());
        commonResponse.setMsg(ResponseCodeEnum.SUCCESS.getText());
        commonResponse.setData(data);

        return commonResponse;
    }

    /**
     * 失败返回消息
     *
     * @param msg
     * @return
     */
    public static CommonResponse failure(String msg) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(ResponseCodeEnum.FAILURE.getValue());
        commonResponse.setMsg(msg);
        commonResponse.setData(null);

        return commonResponse;
    }

    public static CommonResponse paramErr(String msg) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(ResponseCodeEnum.PARAM_ERR.getValue());
        commonResponse.setMsg(msg);
        commonResponse.setData(null);

        return commonResponse;
    }

    /**
     * 通用无数据返回消息
     *
     * @return
     */
    public static CommonResponse noData() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(ResponseCodeEnum.NODATA.getValue());
        commonResponse.setMsg(ResponseCodeEnum.NODATA.getText());
        commonResponse.setData(null);

        return commonResponse;
    }

    /**
     * 服务器异常
     *
     * @return
     */
    public static CommonResponse serverErr() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(ResponseCodeEnum.SERVER_ERR.getValue());
        commonResponse.setMsg(ResponseCodeEnum.SERVER_ERR.getText());
        commonResponse.setData(null);

        return commonResponse;
    }

    /**
     * 服务器异常
     *
     * @return
     */
    public static CommonResponse illegalRequest() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(ResponseCodeEnum.ILLEGAL_REQUEST.getValue());
        commonResponse.setMsg(ResponseCodeEnum.ILLEGAL_REQUEST.getText());
        commonResponse.setData(null);

        return commonResponse;
    }

    public static CommonResponse notFound() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(ResponseCodeEnum.NOT_FOUND.getValue());
        commonResponse.setMsg(ResponseCodeEnum.NOT_FOUND.getText());
        commonResponse.setData(null);

        return commonResponse;
    }

    /**
     * 反射异常
     *
     * @return
     */
    public static CommonResponse reflectErr() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(ResponseCodeEnum.REFLECT_ERR.getValue());
        commonResponse.setMsg(ResponseCodeEnum.REFLECT_ERR.getText());
        commonResponse.setData(null);

        return commonResponse;
    }

    /**
     * 帐号验证错误
     *
     * @return
     */
    public static CommonResponse authFailure(String msg) {
        CommonResponse CommonResponse = new CommonResponse();
        CommonResponse.setCode(ResponseCodeEnum.AUTH_FAILURE.getValue());
        CommonResponse.setMsg(null==msg? ResponseCodeEnum.AUTH_FAILURE.getText():msg);
        CommonResponse.setData(null);

        return CommonResponse;
    }

    public static CommonResponse authConflict() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(ResponseCodeEnum.AUTH_CONFLICT.getValue());
        commonResponse.setMsg(ResponseCodeEnum.AUTH_CONFLICT.getText());
        commonResponse.setData(null);

        return commonResponse;
    }
}
