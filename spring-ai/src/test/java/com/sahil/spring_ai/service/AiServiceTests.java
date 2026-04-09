package com.sahil.spring_ai.service;

import com.sahil.spring_ai.Service.AIService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AiServiceTests {
    @Autowired
    private AIService aiService;

    @Test
    public void testGetJoke(){
        var joke = aiService.getJoke("Dogs");
        System.out.println(joke);
    }
}
