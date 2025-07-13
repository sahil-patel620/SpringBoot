package com.AliceInBakery.Week1HomeWork;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@ConditionalOnProperty(name = "deploy.env",havingValue = "chocolate")
public class ChocolateSyrup implements Syrup{

    public String getSyrupType(){
//        System.out.println("Chocolate Syrup");
        return "Chocolate Syrup";
    }
}
