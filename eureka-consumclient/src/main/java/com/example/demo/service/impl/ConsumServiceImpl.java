package com.example.demo.service.impl;

import com.example.demo.service.ConsumService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2019/3/23.
 */
@Service
public class ConsumServiceImpl implements ConsumService{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String consumPrint() {
        return "consumPrint";
    }

    @Override
    @HystrixCommand(fallbackMethod = "consumServiceError")// 断路器配置，当无法调用如下方法时，就会调用自定的hiError方法。
    public String hiService( String name ) {
        return  restTemplate.getForObject("http://EUREKA-PRODUCTION/index/hi?name=" + name, String.class);
    }

    public String consumServiceError(String name){
        return "hey " +
                name + ", there is some problem with hi page";
    }
}
