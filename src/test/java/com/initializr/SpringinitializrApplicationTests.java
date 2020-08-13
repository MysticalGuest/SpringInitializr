package com.initializr;

import com.initializr.bean.Person;
import org.junit.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationHome;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot单元测试
 *
 * @RunWith(SpringRunner.class): 单元测试使用Spring的驱动器跑，而不是用Junit的
 * 可以在测试期间很方便地类似编码一样进行自动注入等容器的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringinitializrApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc; // 容器

    // LoggerFactory是记录器工厂，记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testHelloService() {
        boolean b = ioc.containsBean("helloService");
        System.out.println(b);
    }

    @Test
    public void contextLoads() {
        System.out.println("Test Person...");
        System.out.println(person);
    }

    @Test
    public void testLog() {
        /**
         * 日志的级别
         * 由低到高：trace<debug<info<waring<error
         * 可以调整输出的日志级别
         * 只打印高级别即以后（更高级别）的信息
         */
        logger.trace("这是跟踪轨迹日志...trace...");
        logger.debug("这是调试日志...debug");
        /**
         * Spring Boot默认使用的是info级别的，输出info级别即以后的内容
         * 没有指定级别的就用Spring Boot默认规定的级别（root级别）
         */
        logger.info("这是信息日志...info...");
        logger.warn("这是警告信息...warning...");
        logger.error("这是错误信息日志，异常捕获...error...");
        // 也可以通过配置文件修改级别
    }

}
