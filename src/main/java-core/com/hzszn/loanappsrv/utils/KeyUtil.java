package com.hzszn.loanappsrv.utils;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.io.*;
import java.security.Key;

/**
 * Created by jhhuang on 2017/3/1
 * QQ:781913268
 * Description：xxx
 */
public class KeyUtil
{
    public static Key getKey() {
        String file1 = KeyUtil.class.getClassLoader().getResource("res/token.txt").getFile();
        File file=new File(file1);
        try {
            if(file.exists()){
                Key key = MacProvider.generateKey(SignatureAlgorithm.HS384);
                ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(file));
                oo.writeObject(key);
                oo.close();
                return key;
            }
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            ois.close();
            Key key= (Key) ois.readObject();
            return key;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
        }

    }
}
