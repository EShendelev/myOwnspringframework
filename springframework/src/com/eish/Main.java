package com.eish;

import com.eish.service.ProductService;
import com.eish.service.PromotionsService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.CustomPostProcessor;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {


    public static void main(String[] args) throws URISyntaxException, IOException {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.addPostProcessor(new CustomPostProcessor());
        beanFactory.instantiate("com.eish.service");
        beanFactory.populateProperties();
        beanFactory.injectBeanNames();
        beanFactory.initializeBeans();

        ProductService productService = (ProductService) beanFactory.getBean("productService");
        PromotionsService promotionsService = (PromotionsService) beanFactory.getBean("promotionsService");
        System.out.println(productService);

        System.out.println(productService.getPromotionsService());
        System.out.println("Bean name = " + promotionsService.getBeanName());
    }
}
