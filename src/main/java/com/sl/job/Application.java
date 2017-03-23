package com.sl.job;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by braveup on 2017/3/23.
 */
public class Application {
    public static void main(String[] args) {
        execute();
    }
    public static  void execute(){
        ApplicationContext  context=new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
