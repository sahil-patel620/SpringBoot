package com.AliceInBakery.Week1HomeWork;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "deploy.env",havingValue = "strawberry")

public class StrawberrySyrup implements Syrup {
    public String getSyrupType(){
//        System.out.println("Strawberry Syrup");
        return "Strawberry Syrup";
    }
}
