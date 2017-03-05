package com.hzszn.loanappsrv.base;

import com.hzszn.loanappsrv.model.JsonResponse;
import com.hzszn.loanappsrv.utils.JsonResponseTool;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import java.io.IOException;
import java.net.SocketTimeoutException;

/**
 * Created by jhhuang on 17-3-5
 * QQ:781913268
 * Description：xxx
 */
public abstract class BaseApiContorller
{
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public JsonResponse serverErrException(Exception e) {
        e.printStackTrace();
        return JsonResponseTool.serverErr();
    }

    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class,
            HttpMediaTypeNotSupportedException.class,
            HttpMessageNotReadableException.class,
            HttpRequestMethodNotSupportedException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class})
    public JsonResponse illegalException(Exception e) {
        e.printStackTrace();
        return JsonResponseTool.illegalRequest();
    }

    @ExceptionHandler({NoSuchRequestHandlingMethodException.class})
    public JsonResponse notFoundException(Exception e) {
        e.printStackTrace();
        return JsonResponseTool.notFound();
    }

    @ExceptionHandler({NullPointerException.class})
    public JsonResponse nullPointerException(NullPointerException e) {
        e.printStackTrace();
        return JsonResponseTool.serverErr();
    }

    @ExceptionHandler({NoSuchFieldException.class, IllegalAccessException.class})
    public JsonResponse reflectException(Exception e) {
        e.printStackTrace();
        return JsonResponseTool.reflectErr();
    }

    @ExceptionHandler(UnexpectedRollbackException.class)
    public JsonResponse rollbackException(Exception e) {
        e.printStackTrace();
        return JsonResponseTool.failure(e.getMessage());
    }

    @ExceptionHandler(SocketTimeoutException.class)
    public JsonResponse netErrException(Exception e) {
        e.printStackTrace();
        return JsonResponseTool.failure("内部网络连接超时");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public JsonResponse duplicateException(Exception e) {
        e.printStackTrace();
        return JsonResponseTool.failure("数据重复(编号/条码/名称)");
    }

    @ExceptionHandler({IOException.class})
    public JsonResponse ioException(Exception e) {
        e.printStackTrace();
        return JsonResponseTool.failure("IO错误");
    }
}
