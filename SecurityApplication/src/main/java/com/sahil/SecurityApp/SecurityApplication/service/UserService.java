package com.sahil.SecurityApp.SecurityApplication.service;

import com.sahil.SecurityApp.SecurityApplication.dto.LoginDto;
import com.sahil.SecurityApp.SecurityApplication.dto.SignUpDto;
import com.sahil.SecurityApp.SecurityApplication.dto.UserDto;
import com.sahil.SecurityApp.SecurityApplication.entity.User;
import com.sahil.SecurityApp.SecurityApplication.exception.ResourceNotFoundException;
import com.sahil.SecurityApp.SecurityApplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(()-> new ResourceNotFoundException("User with email "+ username +" not found."));
    }

    public User getUserById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(()->  new ResourceNotFoundException("User with id "+ userId +" not found."));
    }

    public UserDto signUp(SignUpDto signUpDto) {
        Optional<User> user =userRepository.findByEmail(signUpDto.getEmail());
        if(user.isPresent()){
            throw new BadCredentialsException("User with email already exists " + signUpDto.getEmail());
        }

        User toBeCreatedUser = modelMapper.map(signUpDto, User.class);
        toBeCreatedUser.setPassword(passwordEncoder.encode(toBeCreatedUser.getPassword()));

        User savedUser = userRepository.save(toBeCreatedUser);
        return  modelMapper.map(savedUser, UserDto.class);
    }

}

