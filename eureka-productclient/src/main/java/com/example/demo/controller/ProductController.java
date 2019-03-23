package com.example.demo.controller;

import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/3/23.
 */
@RestController
@RequestMapping("/index")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String getName(String name){
        return "hi " + name + ",i am from port:" + port;
    }

    @RequestMapping("/index")
    public String index(){
        return "index-product";
    }

    @RequestMapping("/print")
    public String getProductPrint(){
        return productService.productPrint();
    }
}
