package com.zjyun.spring.applicationcontext;

import com.zjyun.spring.config.AppConfig;
import com.zjyun.spring.config.WebConfig;
import com.zjyun.spring.model.Bean1;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Description:
 * @Author: Wang Zijian
 * @Date: 2024/5/22
 */
public class ApplicationContextTest {
    public static void main(String[] args) {

        //通过resource 下的applicationContext.xml 解析获取Bean
//        testClassPathXmlApplicationContext();
        //通过系统路径下的XML解析获取bean
//        testFileSystemXmlApplicationContext();
        //通过注解解析获取
//        testAnnotationConfigApplicationContext();
        //通过注解配置解析 的web
        testAnnotationConfigServletWebServerApplicationContext();
    }

    public static void testClassPathXmlApplicationContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
        System.out.println(context.getBean(Bean1.class));
    }

    public static void testFileSystemXmlApplicationContext() {
        ApplicationContext context = new FileSystemXmlApplicationContext("D:\\项目\\王子健-Java\\Java\\springboot\\target\\classes\\WEB-INF\\applicationContext.xml");
        System.out.println(context.getBean(Bean1.class));

    }

    public static void testAnnotationConfigApplicationContext() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println(context.getBean("bean1"));
        System.out.println(context.getBean("bean2"));

    }

    public static void testAnnotationConfigServletWebServerApplicationContext() {
        //基于ServletWeb 服务器的容器实现
        AnnotationConfigServletWebServerApplicationContext context =
                new AnnotationConfigServletWebServerApplicationContext(WebConfig.class);

//        context.getBean("bean1");
//        context.getBean("bean2");
    }
}
