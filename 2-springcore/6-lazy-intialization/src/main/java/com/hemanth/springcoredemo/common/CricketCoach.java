package com.hemanth.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements Coach {
    public  CricketCoach(){
        System.out.println("In Constructor "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "bowl a 5 overs :)";
    }
}
