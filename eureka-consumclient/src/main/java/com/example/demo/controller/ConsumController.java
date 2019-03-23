package com.example.demo.controller;

import com.example.demo.service.ConsumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/3/23.
 */
@RestController
@RequestMapping("index")
public class ConsumController {

    @Autowired
    private ConsumService consumService;

    @RequestMapping("index")
    public String index(){
        return "index-consum";
    }

    @RequestMapping("/print")
    public  String getConsumPrint(){
        return consumService.consumPrint();
    }

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name)
    {
        return consumService.hiService(name);
    }

}
