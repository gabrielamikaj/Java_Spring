package com.betaplan.gabriela.springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @RequestMapping("/")
    public String first(@RequestParam(value="name", required=false) String names, @RequestParam(value="last_name", required=false) String lastName) {
        if( names == null) {
            return "Hello Human";
        } else if(lastName == null) {
            return "Hello " + names;
        } else {
            return "Hello " + names + " " + lastName;
        }
    }

}