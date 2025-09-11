package com.homework.Week5HomeWork.controller;

import com.homework.Week5HomeWork.dto.LoginDto;
import com.homework.Week5HomeWork.dto.SignUpDto;
import com.homework.Week5HomeWork.dto.UserDto;
import com.homework.Week5HomeWork.services.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping(path = "/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpDto signUpDto){
        UserDto userDto = authService.signUp(signUpDto);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto,  HttpServletResponse response) {
        String token = authService.login(loginDto);
        Cookie cookie = new Cookie("token",token);
        cookie.setHttpOnly(true);
//        cookie.setSecure(true);   // used only for HTTPS
        response.addCookie(cookie);
        return ResponseEntity.ok(token);
    }

}
