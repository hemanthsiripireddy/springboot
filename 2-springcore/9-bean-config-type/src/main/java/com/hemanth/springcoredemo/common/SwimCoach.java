package com.hemanth.springcoredemo.common;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In Constructor "+ getClass().getSimpleName());

    }
    @Override
    public String getDailyWorkout() {
        return "This is Swim Coach";
    }
}
