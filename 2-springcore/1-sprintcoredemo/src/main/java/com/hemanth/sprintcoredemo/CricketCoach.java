package com.hemanth.sprintcoredemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "bowl a 5 overs";
    }
}
