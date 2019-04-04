package com.juzhen.demo.eurekafeignclient.feignService.impl;

import com.juzhen.demo.eurekafeignclient.feignService.EurekaFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HiService {

    @Autowired
    private EurekaFeignService eurekaFeignService;

    public String sayHi(String name){
        String s = eurekaFeignService.sayHiFormClientEureka(name);
        return s;

    }
}
