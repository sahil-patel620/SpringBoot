package com.homework.Week5HomeWork.services;

import com.homework.Week5HomeWork.dto.LoginDto;
import com.homework.Week5HomeWork.dto.SignUpDto;
import com.homework.Week5HomeWork.dto.UserDto;
import com.homework.Week5HomeWork.entities.User;
import com.homework.Week5HomeWork.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    public UserDto signUp(SignUpDto signUpDto){
        Optional<User> user = userRepository.findByEmail(signUpDto.getEmail());

        if(user.isPresent()){
            throw new BadCredentialsException("User with username " + signUpDto.getEmail() + " is already exists");
        }

        User toBeSavedUser = modelMapper.map(signUpDto, User.class);
        toBeSavedUser.setPassword(passwordEncoder.encode(toBeSavedUser.getPassword()));

        User savedUser = userRepository.save(toBeSavedUser);
        return  modelMapper.map(savedUser, UserDto.class);
    }

    public String login(LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
        );

        User user = (User)authentication.getPrincipal();
        return jwtService.generateToken(user);
    }
}
