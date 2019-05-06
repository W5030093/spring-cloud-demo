package com.juzhen.demo.serviceturbine.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.juzhen.demo.serviceturbine.constant.AliPayConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AliPayServiceImpl {

    @Value("${ALIPAY_APPID}")
    private String ALIPAY_APPID;
    @Value("${ALIPAY_GATEWAY}")
    private String ALIPAY_GATEWAY;
    @Value("${ALIPAY_PUBLICKEY}")
    private String ALIPAY_PUBLICKEY;
    @Value("${ALIPAY_PRIVATEKEY}")
    private String ALIPAY_PRIVATEKEY;


    public String do_pay() throws AlipayApiException {

        AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY
                ,ALIPAY_APPID
                ,ALIPAY_PRIVATEKEY
                ,AlipayConstants.FORMAT_JSON
                ,AlipayConstants.CHARSET_UTF8
                ,ALIPAY_PUBLICKEY);
        AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();
        request.setNotifyUrl("http://www.wyczzzzz.cn:8080/park-system-job/jz");
        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        model.setOutTradeNo(UUID.randomUUID().toString());
        model.setSubject("测试");
        model.setTotalAmount("10");
        model.setProductCode("QUICK_WAP_WAY");
        request.setBizModel(model);
        String body = alipayClient.pageExecute(request).getBody();
        System.out.println(body);
        return  null;
    }
}
