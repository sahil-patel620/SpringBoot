package com.sahilPatel.week1Introduction.Week1SpringBootIntroduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBservice {

//  @Autowired

//  Constructor dependency injection , in  this type of injection we can make final , make sure if dependency is core, then make it constructor injection
    final private DB db;

    public DBservice(DB db){
        this.db = db;
    }

    String getData(){
        return db.getData();
    }
}
