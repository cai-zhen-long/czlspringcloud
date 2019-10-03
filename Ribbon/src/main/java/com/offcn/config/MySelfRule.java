package com.offcn.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/10/3.
 */
@Configuration
public class MySelfRule
{
    @Bean
    @LoadBalanced
    public IRule myRule()
    {
        return new RandomRule_ZY();// 我自定义为每台机器5次
    }
}