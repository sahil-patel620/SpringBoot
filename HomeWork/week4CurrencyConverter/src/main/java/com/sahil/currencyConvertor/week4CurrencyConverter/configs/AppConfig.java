package com.sahil.currencyConvertor.week4CurrencyConverter.configs;

import com.sahil.currencyConvertor.week4CurrencyConverter.auth.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditorAwareImp")
public class AppConfig {

    @Bean
    public AuditorAware<String> getAuditorAwareImp(){
        return new AuditorAwareImpl();
    }
}
