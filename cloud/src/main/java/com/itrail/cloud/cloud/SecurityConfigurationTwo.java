package com.itrail.cloud.cloud;
/** 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigurationTwo {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
            .ignoringAntMatchers("/encrypt/**")
            .ignoringAntMatchers("/decrypt/**");
        http.authorizeRequests((requests) -> requests.anyRequest()
            .authenticated());
        http.formLogin();
        http.httpBasic();
        return http.build();
    }
    
}*/
