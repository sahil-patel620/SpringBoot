package com.AliceInBakery.Week1HomeWork;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "deploy.env",havingValue = "strawberry")

public class StrawberryFrosting implements  Frosting{
    public String getFrostingType(){
        System.out.println("Strawberry Frosting");
        return "Strawberry Frosting";
    }
}
