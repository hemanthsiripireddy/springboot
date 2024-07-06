package com.hemanth.sprintcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach coach;

    @Autowired
    public DemoController(Coach coach){
        this.coach=coach;
    }
    @GetMapping("/cricketCoach")
    public String get(){
        return  coach.getDailyWorkout();

    }
}
