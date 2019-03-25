package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableHystrix //开启断路器
public class EurekaConsumclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumclientApplication.class, args);
	}

	@Bean
	@LoadBalanced //负载均衡@LoadBalanced注解表明这个restTemplate开启负载均衡的功能
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
