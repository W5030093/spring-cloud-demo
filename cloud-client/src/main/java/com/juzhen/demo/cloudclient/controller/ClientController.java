package com.juzhen.demo.cloudclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClientController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/hi")
    @ResponseBody
    public String hiSpringCloud(@RequestParam(value = "name", defaultValue = "wyc") String name) {

        System.out.println(port);
        return "{name:" + name + "}";
    }


}
