package com.juzhen.demo.cloudclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Properties;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class CloudClientApplicationTests {

    //@Test
    public void contextLoads() {
    }

    public static void main(String[] args) throws IOException {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("application.properties"));
        Resource resource = new ClassPathResource("application.properties");
        Resource resource1 = new FileSystemResource("application.properties");
        Properties properties = new Properties();
        properties.load(resource1.getInputStream());
        System.out.println(resource1.getURI().toString());

    }
}
