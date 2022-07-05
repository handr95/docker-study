package com.study.dockerhelloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Environment evn;

    @GetMapping("/hello")
    public String hello() {
        System.out.println(evn.getProperty("POST"));
        return "hello";
    }
}
