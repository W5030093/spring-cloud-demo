package com.cloud.dauly.clouddaily;

import com.cloud.dauly.clouddaily.config.GlobalLog;
import jdk.nashorn.internal.objects.Global;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CloudDailyApplication {

    private final static Logger logger = LoggerFactory.getLogger(CloudDailyApplication.class);

    public static void main(String[] args) {
        logger.info("test");
        SpringApplication.run(CloudDailyApplication.class, args);
    }

}
