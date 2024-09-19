package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration  // 클래스를 구성 클래스로 표시
public class ProjectConfig {

    @Bean       // 반환된 값을 스프링 컨텍스트에 빈으로 추가하도록 스프링에 지시
    public UserDetailsService userDetailsService() {
        var userDetailsService = new InMemoryUserDetailsManager();  // var 키워드로 구문을 간소화, 세부 정보를 감춤, 로컬 선언에만 이용

        var user = User.withUsername("yoon")    // 주어진 사용자 이름, 암호, 권한 목록으로 사용자 생성
                .password("1234")
                .authorities("read")
                .build();

        userDetailsService.createUser(user);    // UserDetailsService에서 관리하도록 사용자 추가

        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 모든 요청에 인증이 필요
        http.authorizeHttpRequests(authz -> authz.anyRequest().authenticated()).httpBasic(Customizer.withDefaults());

        // 모든 요청에 인증없이 요청 가능
        //http.authorizeHttpRequests(authz -> authz.anyRequest().permitAll()).httpBasic(Customizer.withDefaults());

        return http.build();
    }
}