package com.lc.dubbo.provider;

import com.lc.dubbo.api.DemoService;
import org.apache.dubbo.config.annotation.DubboService;


@DubboService
public class DemoServiceImpl implements DemoService {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello!" + name);
    }
}
