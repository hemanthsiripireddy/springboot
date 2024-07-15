package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class securityConfig {


    @Bean
    public UserDetailsManager userDetailsManager(DataSource source){
      JdbcUserDetailsManager db=new  JdbcUserDetailsManager(source);
      db.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");
        db.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?");
        return db;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
                configurer->configurer.requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")


        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();
    }
/*

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails mahesh= User.builder().username("mahesh")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();
        UserDetails suresh= User.builder().username("suresh")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();
        UserDetails ramesh= User.builder().username("ramesh")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();
        return  new InMemoryUserDetailsManager(mahesh,suresh,ramesh);

    }
*/
}
