package com.nowcoder.community.service;

import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype")
public class AlphaService {

    public AlphaService() {
        System.out.println("实例化");
    }

//    创建对象之后
    @PostConstruct
    public void init() {
        System.out.println("初始化");
    }

//    销毁对象之前
    @PreDestroy
    public void destroy() {
        System.out.println("销毁");
    }
}

