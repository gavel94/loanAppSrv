package com.hzszn.loanappsrv.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzszn.loanappsrv.base.BaseInterceptor;
import com.hzszn.loanappsrv.constant.AuthHeaderEnum;
import com.hzszn.loanappsrv.utils.JsonResponseTool;
import com.hzszn.loanappsrv.utils.ProtocolTool;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jhhuang on 17-3-5
 * QQ:781913268
 * Description：xxx
 */
public class HeaderInterceptor extends BaseInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception
    {
        if (RequestMethod.OPTIONS.name().equals(httpServletRequest.getMethod()))
        {
            return true;
        }

        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");

        Integer userId = ProtocolTool.validateUser(
                httpServletRequest.getHeader(AuthHeaderEnum.X_LOAN_TOKEN.getValue())
        );

        if (userId < 1)
        {
            httpServletResponse.setCharacterEncoding("utf-8");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(httpServletResponse.getWriter(), JsonResponseTool.authFailure(null));
            httpServletResponse.getWriter().close();
            return false;
        }

        return true;

    }

}
