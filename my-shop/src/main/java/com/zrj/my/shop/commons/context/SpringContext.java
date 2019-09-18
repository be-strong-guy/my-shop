package com.zrj.my.shop.commons.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: SpringContext
 * @description:
 * @author: zrj
 * @create: 2019-09-11 16:28
 **/
public class SpringContext {
    public Object getBean(String beanID){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-context.xml");
        return ac.getBean(beanID);
    }
}
