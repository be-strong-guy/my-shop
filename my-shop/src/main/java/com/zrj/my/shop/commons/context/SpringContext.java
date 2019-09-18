package com.zrj.my.shop.commons.context;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @program: SpringContext
 * @description:
 * @author: zrj
 * @create: 2019-09-11 16:28
 **/
@Component
public class SpringContext implements ApplicationContextAware,DisposableBean{

    private static final Logger logger = LoggerFactory.getLogger(SpringContext.class);

    private static ApplicationContext applicationContext;
    public void destroy() throws Exception {
        logger.debug("销毁SpringContext 中的ApplicationContext :{}",applicationContext);
        applicationContext=null;
    }

    /**
     * 从静态变量 applicationContext 中获取 Bean，自动转型成所赋值对象的类型
     * @param beanId
     * @param <T>
     * @return
     */
    public static <T> T getBean(String beanId){
        return (T) applicationContext.getBean(beanId);
    }

    /**
     * 从静态变量 applicationContext 中获取 Bean，自动转型成所赋值对象的类型
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> tClass){
        return applicationContext.getBean(tClass);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContext.applicationContext=applicationContext;
    }

    /**
     * 断言 Context 已经注入
     */
    private static void assertContextInjected() {
        Validate.validState(applicationContext != null, "applicationContext 属性未注入，请在 spring-context.xml 配置中定义 SpringContext");
    }
}
