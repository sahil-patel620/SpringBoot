package com.AliceInBakery.Week1HomeWork;

import org.springframework.stereotype.Component;

@Component
public class CakeBaker {

    private final Frosting frosting;
    private final Syrup syrup;

    public CakeBaker(Frosting frosting, Syrup syrup) {
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public void bakeCake(){
        System.out.println("Bakingcake with: " + frosting.getFrostingType() + " and " + syrup.getSyrupType());
    }

}
