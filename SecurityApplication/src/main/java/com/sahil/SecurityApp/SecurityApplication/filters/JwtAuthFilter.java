package com.sahil.SecurityApp.SecurityApplication.filters;

import com.sahil.SecurityApp.SecurityApplication.entity.User;
import com.sahil.SecurityApp.SecurityApplication.service.JwtService;
import com.sahil.SecurityApp.SecurityApplication.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private  final JwtService jwtService;
    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("Authorization");
        if(requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer")){
            filterChain.doFilter(request, response);
            return;
        }

        String token = requestTokenHeader.split("Bearer ")[1];
        Long userId = jwtService.getUserIdFromToken(token);

        // SecurityContextHolder.getContext().getAuthentication() == null checks 'is this request unauthenticated'
        if(userId != null && SecurityContextHolder.getContext().getAuthentication() == null){
            User user = userService.getUserById(userId);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null,null);
            authenticationToken.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request));    // this will provide some details like client Ip address , session ID associated with the request
            // To put this user to Spring security context holder
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request,response);
        // do with the response
    }
}
