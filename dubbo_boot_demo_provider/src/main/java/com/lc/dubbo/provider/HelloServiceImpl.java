package com.lc.dubbo.provider;

import com.lc.dubbo.api.HelloService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello!" + name);
    }
}
