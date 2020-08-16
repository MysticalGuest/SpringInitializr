package com.initializr.controller;


import com.initializr.bean.Person;
import com.initializr.exception.UserNotExistException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Map;

@Controller
//@ResponseBody
//@RestController // 这个类的所有方法返回的数据直接写给浏览器，（如果是对象转换为JSON数据）
public class HelloController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @Value("${person.name}")
    private String name;

    // 当静态文件夹下有多个index页面，但我想用模板引擎下的
    // 比如项目public文件夹下有index.html, templates文件夹在也有
//    @RequestMapping({"/", "index.html"})
//    public String index(){
//        return "index";
//    }
    // 注释掉，也可以通过配置类实现

    @RequestMapping("hello")
    @ResponseBody
    public String Hello(){
        return "Hello World!" + name;
    }

    @GetMapping("getMapping")
    @ResponseBody
    public String getMapping(){
        return "GetMapping Annotation";
    }

    @RequestMapping("thymeleaf")
    public String thymeleaf(Map<String, Object> map){
        LOG.info("thymeleaf...");
        map.put("text", "设置div文本值");
        map.put("utext", "<h2>转义测试</h2>");
        map.put("users", Arrays.asList("user1", "user2", "user3"));
//        classpath:/templates/thymeleaf.html
        return "thymeleaf";
    }

    @RequestMapping("testMyException")
    @ResponseBody
    public String testMyException(@RequestParam("user") String user){
        // http://localhost:8088/testMyException?user=Tom
        if(user.equals("Tom")){
            throw new UserNotExistException();
        }
        return "testMyException";
    }

    // RESTAPI的方式
}
