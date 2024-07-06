package com.hemanth.springcoredemo.config;

import com.hemanth.springcoredemo.common.Coach;
import com.hemanth.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsConfig {

    @Bean("swimCoach1")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
