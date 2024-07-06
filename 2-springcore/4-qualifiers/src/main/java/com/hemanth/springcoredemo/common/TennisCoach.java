package com.hemanth.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements  Coach{
    @Override
    public String getDailyWorkout() {
        return "I'm playing Tennis";
    }
}
