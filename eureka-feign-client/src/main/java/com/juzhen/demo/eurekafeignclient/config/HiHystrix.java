package com.juzhen.demo.eurekafeignclient.config;

import com.juzhen.demo.eurekafeignclient.feignService.EurekaFeignService;
import org.springframework.stereotype.Component;

/**
 * feign  容错 逻辑处理类
 */
@Component
public class HiHystrix implements EurekaFeignService {


    @Override
    public String sayHiFormClientEureka(String name) {
        System.out.println("feign error");
        return null;
    }
}
