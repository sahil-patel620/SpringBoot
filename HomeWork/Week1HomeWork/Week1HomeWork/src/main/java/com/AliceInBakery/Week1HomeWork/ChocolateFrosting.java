package com.AliceInBakery.Week1HomeWork;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@ConditionalOnProperty(name = "deploy.env",havingValue = "chocolate")

public class ChocolateFrosting implements Frosting{
    public String getFrostingType(){
//        System.out.println("Chocolate Frosting");
        return "Chocolate Frosting";
    }
}
