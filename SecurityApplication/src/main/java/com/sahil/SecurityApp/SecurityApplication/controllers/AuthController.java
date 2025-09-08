package com.sahil.SecurityApp.SecurityApplication.controllers;

import com.sahil.SecurityApp.SecurityApplication.dto.LoginDto;
import com.sahil.SecurityApp.SecurityApplication.dto.SignUpDto;
import com.sahil.SecurityApp.SecurityApplication.dto.UserDto;
import com.sahil.SecurityApp.SecurityApplication.service.AuthService;
import com.sahil.SecurityApp.SecurityApplication.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping(path = "/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpDto signUpDto){
       UserDto userDto = userService.signUp(signUpDto);
       return ResponseEntity.ok(userDto);
    }

    @PostMapping(path = "/login")
    public  ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpServletResponse response){
        String token = authService.login(loginDto);

        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
//        cookie.setSecure(true);   // used only for HTTPS
        response.addCookie(cookie);

        return ResponseEntity.ok(token);
    }


}
