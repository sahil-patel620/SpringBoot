package com.sahilPatel.week1Introduction.Week1SpringBootIntroduction;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//import org.springframework.stereotype.Component;
//@Component
public class Apple {

    void eatApple(){
        System.out.println("Eating an Apple");
    }

    @PostConstruct
    void callThisBeforeAppleUsed(){
        System.out.println("Creating before Apple is used");
    }

    @PreDestroy
    void callThisBeforeDestroy(){
        System.out.println("Destroying the Bean");
    }
}
