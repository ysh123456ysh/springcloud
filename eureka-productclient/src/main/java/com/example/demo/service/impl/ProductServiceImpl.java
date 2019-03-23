package com.example.demo.service.impl;

import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/3/23.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public String productPrint() {
        return "productprint";
    }
}
