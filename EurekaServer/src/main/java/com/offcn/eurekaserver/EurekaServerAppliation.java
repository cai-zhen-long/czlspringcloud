package com.offcn.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Administrator on 2019/10/2.
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerAppliation {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerAppliation.class,args);
    }
}
