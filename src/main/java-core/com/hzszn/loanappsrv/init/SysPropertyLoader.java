package com.hzszn.loanappsrv.init;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by jhhuang on 17-3-5
 * QQ:781913268
 * Description：初始化加载文件
 */
public class SysPropertyLoader extends PropertyPlaceholderConfigurer
{
    private static Properties properties = new Properties();

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException
    {
        try {
            try {
                String propertyPath = System.getProperty("sys.properties.path");
                if (null != propertyPath && "" != propertyPath) {
                    properties.load(new FileInputStream(new File(propertyPath)));
                    /*for(String key : properties.stringPropertyNames()) {
                        System.setProperty(key, properties.getProperty(key));
                    }*/
                }
            } catch (IOException e) {
            }

            Properties ex = this.mergeProperties();
            //如外部有,则外部优先
            if (!properties.isEmpty()) {
                ex.putAll(properties);
            }
            this.convertProperties(ex);
            this.processProperties(beanFactory, ex);
        } catch (IOException var3) {
            throw new BeanInitializationException("Could not load properties", var3);
        }
    }

    public static Properties getProperties() {
        return properties;
    }
}
