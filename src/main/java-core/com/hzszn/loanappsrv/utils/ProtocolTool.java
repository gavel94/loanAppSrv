package com.hzszn.loanappsrv.utils;

import com.hzszn.loanappsrv.init.SysPropertyLoader;
import com.hzszn.loanappsrv.model.UserSession;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Calendar;

/**
 * Created by jhhuang on 17-3-5
 * QQ:781913268
 * Description：xxx
 */
@Component
public class ProtocolTool implements ApplicationContextAware
{
    private static Key key;
    public static Integer validateUser(String token)
    {
        int userId;
        try
        {
            userId = Integer.parseInt(TokenUtils.getName(token, key));
            UserSession userSession = new UserSession();
            userSession.setUserId(userId);
            UserSession.setCurrent(userSession);
        } catch (ExpiredJwtException e)
        {
            userId = -1;
        } catch (Exception e)
        {
            userId = 0;
        }

        return userId;
    }

    public static String createToken(int userId)
    {
        Calendar c = Calendar.getInstance();
        c.add(c.DAY_OF_YEAR, Integer.parseInt(SysPropertyLoader.getProperties().getProperty("token.validate.time")));
        return TokenUtils.getJWTString(String.valueOf(userId),c.getTime(),key);
    }


    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        key = KeyUtil.getKey();
    }
}
