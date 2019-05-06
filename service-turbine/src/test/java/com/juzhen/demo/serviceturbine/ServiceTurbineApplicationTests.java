package com.juzhen.demo.serviceturbine;

import com.alipay.api.AlipayApiException;
import com.juzhen.demo.serviceturbine.service.AliPayServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTurbineApplicationTests {

    @Autowired
    private AliPayServiceImpl aliPayService;

    @Test
    public void contextLoads() throws AlipayApiException {

    aliPayService.do_pay();
    }

}
