package com.lc.dubbo.loadbalance;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.cluster.LoadBalance;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 负载均衡一定是在有多个invokers才会生效，如果只有一个invoker，dubbo自身就选择了
 * 自定义的spi可以不用注入到spring 容器，dubbo会通过反射直接获取到对应类的实例
 */
//@Component
public class MyLoadBalance implements LoadBalance {
    @Override
    public <T> Invoker<T> select(List<Invoker<T>> invokers, URL url, Invocation invocation) throws RpcException {
        if (CollectionUtils.isEmpty(invokers)) {
            return null;
        }
        return invokers.get(0);
    }
}
