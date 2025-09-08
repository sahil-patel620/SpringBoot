package com.sahil.SecurityApp.SecurityApplication;

import com.sahil.SecurityApp.SecurityApplication.entity.User;
import com.sahil.SecurityApp.SecurityApplication.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityApplicationTests {

    @Autowired
    private JwtService jwtService;

	@Test
	void contextLoads() {
        
        User user = new User(4L, "sahil@gmail.com", "1234","Sahil");

        String token = jwtService.generateToken(user);
        System.out.println(token);
        Long id = jwtService.getUserIdFromToken(token);
        System.out.println(id);
	}
}
