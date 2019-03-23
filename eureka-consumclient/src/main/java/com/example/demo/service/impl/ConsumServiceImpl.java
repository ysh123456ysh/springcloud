package com.example.demo.service.impl;

import com.example.demo.service.ConsumService;
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
    public String hiService( String name ) {
        return  restTemplate.getForObject("http://EUREKA-PRODUCTION/index/hi?name=" + name, String.class);
    }
}
