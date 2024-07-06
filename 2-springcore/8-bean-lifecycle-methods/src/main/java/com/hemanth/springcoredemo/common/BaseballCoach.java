package com.hemanth.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    public BaseballCoach(){
        System.out.println("In Constructor "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "I'm playing BaseBall";
    }
}
