package com.initializr;

import com.initializr.bean.Person;
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

}
