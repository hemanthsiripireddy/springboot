package com.hemanth.springcoredemo.rest;

import com.hemanth.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach coach;

    @Autowired
    public void setCoach(Coach theCoach) {
        coach = theCoach;
    }

    @GetMapping("/cricketCoach")
    public String get() {
        return coach.getDailyWorkout();

    }
}
