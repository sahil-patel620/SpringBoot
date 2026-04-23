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
        var joke = aiService.getJoke("Programmers");
        System.out.println(joke);
    }

    @Test
    public void testEmbedding(){
        var embed = aiService.getEmbedding("This is a huge text");
        System.out.println(embed.length);
        for (float e: embed){
            System.out.print(e+"");
        }
    }

    @Test
    public void testStoreData(){
        aiService.ingestDataToVectorStore();
    }

    @Test
    public void testSimilaritySearch(){
      var res = aiService.similaritySearch("A team of people travel through a wormhole in space");
      for(var doc: res){
      System.out.println(doc);
      }
    }
}
