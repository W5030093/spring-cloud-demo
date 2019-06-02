package com.juzhen.demo.eurekafeignclient.feignService;

import com.juzhen.demo.eurekafeignclient.config.FeignConfig;
import com.juzhen.demo.eurekafeignclient.config.HiHystrix;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 配置feign   fallback位熔断器熔断后 处理失败的逻辑
 */
@FeignClient(value = "cloud-client", configuration = FeignConfig.class, fallback = HiHystrix.class)
public interface EurekaFeignService {

    @GetMapping(value = "/hi")
    String sayHiFormClientEureka(@RequestParam(value = "name", defaultValue = "wyc") String name);
}
