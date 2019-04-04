package com.juzhen.demo.eurekafeignclient.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.management.MXBean;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * feign配置类  修改默认的重试参数
 */
@Configuration
public class FeignConfig {

    /**
     *   持续时间   最大重试次数
     * @return
     */
    @Bean
    public Retryer feignRetryer(){

        return new Retryer.Default(100,SECONDS.toMillis(1),5);
    }
}
