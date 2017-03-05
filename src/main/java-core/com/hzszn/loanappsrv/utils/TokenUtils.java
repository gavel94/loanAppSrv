package com.hzszn.loanappsrv.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by jhhuang on 2017/3/1
 * QQ:781913268
 * Description：xxx
 */
public class TokenUtils
{
    public static String getJWTString(String tel, Date expires, Key key)
    {
        if (tel == null)
        {
            throw new NullPointerException("null username is illegal");
        }

        if (expires == null)
        {
            throw new NullPointerException("null expires is illegal");
        }
        if (key == null)
        {
            throw new NullPointerException("null key is illegal");
        }
        //用签名算法HS256和私钥key生成token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        String jwtString = Jwts.builder()
                .setIssuer("sanzhiniao")//设置发行人
                .setSubject(tel)//设置抽象主题
                .setAudience("user")//设置角色
                .setExpiration(expires)//过期时间
                .setIssuedAt(new Date())//设置现在时间
                .setId("1")//版本1
                .signWith(signatureAlgorithm, key)
                .compact();
        return jwtString;
    }

    public static boolean isValid(String token, Key key)
    {
        try
        {
            Jwts.parser().setSigningKey(key).parseClaimsJws(token.trim());
            return true;
        } catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public static String getName(String jwsToken, Key key)
    {
        if (isValid(jwsToken, key))
        {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);
            return claimsJws.getBody().getSubject();
        }
        return null;
    }

    public static void main(String[] args)
    {
        Key key = KeyUtil.getKey();
        Calendar c = Calendar.getInstance();
        c.add(c.SECOND, 5);
        String token = getJWTString("123456789", c.getTime(), key);
        System.out.println(token);
        System.out.println("验签结果" + isValid(token, key));
        System.out.println("用户名" + getName(token, key));
        try
        {
            Thread.currentThread().sleep(6000);
            System.out.println("用户名" + getName(token, key));
            System.out.println("验签结果" + isValid(token, key));
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
