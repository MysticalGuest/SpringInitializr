package com.initializr.controller;


import com.initializr.bean.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Controller
//@ResponseBody
@RestController // 这个类的所有方法返回的数据直接写给浏览器，（如果是对象转换为JSON数据）
public class HelloController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @Value("${person.name}")
    private String name;

    @RequestMapping("")
//    @ResponseBody
    public String Hello(){
        return "Hello World!" + name;
    }

    @GetMapping("getMapping")
    @ResponseBody
    public String getMapping(){
        return "GetMapping Annotation";
    }

    // RESTAPI的方式
}
