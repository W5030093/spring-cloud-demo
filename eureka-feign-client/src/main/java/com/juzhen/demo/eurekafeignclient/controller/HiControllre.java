package com.juzhen.demo.eurekafeignclient.controller;

import com.juzhen.demo.eurekafeignclient.feignService.EurekaFeignService;
import com.juzhen.demo.eurekafeignclient.feignService.impl.HiService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiControllre {

    @Autowired
    HiService hiService;

    @HystrixCommand(fallbackMethod = "sayHiFormClientEureka")
    @RequestMapping("/hi")
    public String hiEurekaFeign(@RequestParam String name){

        String s = hiService.sayHi(name);
        return s;
    }

    public String sayHiFormClientEureka(@RequestParam String name) {
        System.out.println("feign error1");
        return name;
    }
}
