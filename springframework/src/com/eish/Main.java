package com.eish;

import com.eish.service.ProductService;
import org.springframework.beans.factory.BeanFactory;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {


    public static void main(String[] args) throws URISyntaxException, IOException {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.instantiate("com.eish.service");

        ProductService productService = (ProductService) beanFactory.getBean("productService");
        System.out.println(productService);
    }
}
