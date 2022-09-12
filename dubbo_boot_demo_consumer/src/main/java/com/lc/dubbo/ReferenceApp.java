package com.lc.dubbo;

import com.lc.dubbo.api.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDubbo
public class ReferenceApp {
    @DubboReference
    private DemoService demoService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ReferenceApp.class, args);
        ReferenceApp app = context.getBean(ReferenceApp.class);
        app.doSay("lc");
        System.out.println("Wait");
        try {
            new CountDownLatch(1).await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSay(String name) {
        demoService.sayHello(name);
    }
}
