package com.juzhen.demo.cloudserver1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudServer1ApplicationTests {

    @Test
    public void contextLoads() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        CloudServer1Application cloudServer1Application = classPathXmlApplicationContext.getBean(CloudServer1Application.class);
        classPathXmlApplicationContext.close();
    }

}
