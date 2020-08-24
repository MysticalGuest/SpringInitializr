package com.initializr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

//@ImportResource(locations = {"classpath:beans.xml"})
@MapperScan("com.initializr.mapper")
@SpringBootApplication
public class SpringinitializrApplication {

    public static void main(String[] args) {
        System.out.println("Start...");
        SpringApplication.run(SpringinitializrApplication.class, args);
        System.out.println("Success...");
    }

    // 定制视图解析器
    @Bean
    public ViewResolver myViewResolver() {
        return new MyViewResolver();
    }

    private static class MyViewResolver implements ViewResolver {

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }

}
