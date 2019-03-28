package com.juzhen.demo.eurekaribbonclient.controller;


import com.juzhen.demo.eurekaribbonclient.controller.service.impl.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CloudController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RibbonService ribbonService;
    @RequestMapping("/hi")
    public String hiSpringCloud(@RequestParam(value = "name",defaultValue = "wyc")String name){

        System.out.println("你好");
        ribbonService.hi();
        return "{name:"+name+"}";
    }
    @RequestMapping("/testRibbon")
    @ResponseBody
    public String hiSpring(){

        ServiceInstance serviceInstance = loadBalancerClient.choose("cloud-client");

        System.out.println(serviceInstance.getPort());
        return "{name:"+serviceInstance.getPort()+"}";
    }
}
