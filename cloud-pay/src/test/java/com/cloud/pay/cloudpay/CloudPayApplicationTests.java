package com.cloud.pay.cloudpay;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpTemplateMsgService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudPayApplicationTests {

    @Inject
    protected WxMpService wxService;



    @Test
    public void contextLoads() throws WxErrorException {
        List<WxMpTemplate> allPrivateTemplate =
                wxService.getTemplateMsgService().getAllPrivateTemplate();
        System.out.println(allPrivateTemplate.toString());
    }

}
