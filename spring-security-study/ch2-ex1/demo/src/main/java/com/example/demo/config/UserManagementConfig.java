package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * 사용자 관리와 암호 관리를 위한 구성 클래스
 */
@Configuration
public class UserManagementConfig {
    @Bean   // 반환된 값을 스프링 컨텍스트에 빈으로 추가
    public UserDetailsService userDetailsService() {
        var userDetailService = new InMemoryUserDetailsManager();

        var user = User.withUsername("yoon")
                .password("1234")
                .authorities("read")
                .build();

        // UserDetailsService에서 관리하도록 사용자 추가
        userDetailService.createUser(user);

        return userDetailService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
