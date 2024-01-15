package com.gabriela.springboot.omikuji.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class home {

    @RequestMapping("")
    public String index() {
        return "index";
    }

    @RequestMapping(value="/process", method=RequestMethod.POST)
    public String process(
            @RequestParam(value="number") String number,
            @RequestParam(value="city") String city,
            @RequestParam(value="person") String person,
            @RequestParam(value="hobby") String hobby,
            @RequestParam(value="thing") String thing,
            @RequestParam(value="say") String say,
            HttpSession session) {
        // save data forms
        session.setAttribute("number", number);
        session.setAttribute("city", city);
        session.setAttribute("person", person);
        session.setAttribute("hobby", hobby);
        session.setAttribute("thing", thing);
        session.setAttribute("say", say);

        return "redirect:/omikuji/show";
    }

    @RequestMapping("/show")
    public String show(HttpSession session) {
        return "show";
    }
}