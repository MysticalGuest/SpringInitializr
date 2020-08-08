package com.initializr.bean;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中配置的每一个属性的值，映射到这个数组中
 * @ConfigurationProperties: 告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
 * prefix = "person": 配置文件中哪个下面的所有属性进行一一映射
 *
 * 只有这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties功能
 * @ConfigurationProperties默认从全局配置文件中获取值
 */
@PropertySource(value = {"classpath:person.properties"})
@Component
@ConfigurationProperties(prefix = "person")
//@Validated // JSR303数据校验
public class Person {

    // 另一种方式，Spring的底层注解
    /**
     * 类似以前
     * <bean class="Person">
     *     <property name="name" value="MysteryGuest"></property>
     * </bean>
     * <bean>标签相当于@Compoent
     * <property>标签中的value相当于@Value
     * value的参数可以是字面量、${key}从环境变量或配置文件获取值、#{SpEL}
     */
//    @Value("${person.name}")
//    @Email // @value不支持
    private String name;
//    @Value("#{11*2}")
    private Integer age;
    private Date birth;
//    @Value("${person.map}")
    private Map<String, Object> map;
    private List<Object> list;
    private Pet pet;

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", map=" + map +
                ", list=" + list +
                ", pet=" + pet +
                '}';
    }
}
