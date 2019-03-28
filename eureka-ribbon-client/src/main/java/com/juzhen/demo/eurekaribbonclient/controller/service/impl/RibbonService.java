package com.juzhen.demo.eurekaribbonclient.controller.service.impl;


import com.juzhen.demo.eurekaribbonclient.dic.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    public String hi(){
        String result = restTemplate.getForObject(Constant.RibbonService,String.class);
        return result;
    }
}
