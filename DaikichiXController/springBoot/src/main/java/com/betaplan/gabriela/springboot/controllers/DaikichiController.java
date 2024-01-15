package com.betaplan.gabriela.springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {

    @RequestMapping("")
        public String homeMethod(){
        return "Welcome!";
        }
    @GetMapping("/today")
    public String todayMethod(){
        return "Today you will find luck in all your endeavors!";
    }
    @GetMapping("/tomorrow")
    public String tomorrowMethod(){
        return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
    }


}
