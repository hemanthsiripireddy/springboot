package com.hemanth.springcoredemo.rest;

import com.hemanth.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach coach;

    //private Coach anotherCoach;

    @Autowired
    public DemoController( @Qualifier("swimCoach1") Coach coach) {
        System.out.println("In Constructor "+ getClass().getSimpleName());


        this.coach = coach;
       // this.anotherCoach=coachB;
    }

    @GetMapping("/cricketCoach")
    public String get() {
        return coach.getDailyWorkout();

    }


//    @GetMapping("/check")
//    public String checking() {
//        return "Comparing coach with anotherCoach "+(coach==anotherCoach);
//
//    }
}
