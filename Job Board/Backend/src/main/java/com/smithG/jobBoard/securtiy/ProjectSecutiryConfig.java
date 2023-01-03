package com.smithG.jobBoard.securtiy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecutiryConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                        .requestMatchers("/job-seeker", "/employer").authenticated()
                        .requestMatchers("/jobs").permitAll()
                .and().formLogin()
                .and().httpBasic();

        return http.build();
    }
}
