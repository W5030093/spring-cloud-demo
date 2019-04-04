package com.juzhen.demo.eurekaribbonclient.controller.service.impl;


import com.juzhen.demo.eurekaribbonclient.dic.Constant;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    //启动熔断器
    @HystrixCommand(fallbackMethod = "hiError")
    public String hi(){
        String result = restTemplate.getForObject(Constant.RibbonService,String.class);
        return result;
    }

    public String hiError(){
        System.out.println("error");
        return "hi,error";
    }
}
