package com.homework.Week5HomeWork.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class LoggingFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    String method = request.getMethod();
    String uri = request.getRequestURI();
    String clientIp = request.getRemoteAddr();
    long startTime = System.currentTimeMillis();
    log.info("Incoming Request : [{}] {}  client Ip = {} ",method, uri, clientIp);

    filterChain.doFilter(request,response);

    long duration = System.currentTimeMillis() - startTime;
    int status = response.getStatus();
    log.info("Outgoing Response: [{}] {}  Status = {} (took {} ms)" ,method, uri, status, duration);
    }
}
