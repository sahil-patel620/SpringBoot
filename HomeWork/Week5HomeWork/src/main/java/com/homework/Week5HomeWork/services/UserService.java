package com.homework.Week5HomeWork.services;

import com.homework.Week5HomeWork.entities.User;
import com.homework.Week5HomeWork.exceptions.ResourceNotFoundException;
import com.homework.Week5HomeWork.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(()->new BadCredentialsException("User with email "+ username + " not found"));
    }

    public User getUserById(Long userId){
        return  userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id "+ userId));
    }


}
