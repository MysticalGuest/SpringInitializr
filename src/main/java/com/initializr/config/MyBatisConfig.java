package com.initializr.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

// 由于上面的org.apache.ibatis.session.Configuration, 所以这里使用全类名
@org.springframework.context.annotation.Configuration
public class MyBatisConfig {

    /* 使用注解版MyBatis时, 本来数据库department表中字段是departmentName,
    如果将其改为department_name后, 就取不到值了, 如果不使用注解版, 可以直接在配置文件中配置驼峰命名规则,
    但现在只能使用配置类了
    */
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer(){

            @Override
            public void customize(Configuration configuration) {
                // 开启驼峰命名法规则
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
