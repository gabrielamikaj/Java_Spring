package com.gabriela.springboot.counter.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {
    @RequestMapping("/")
    public String index(HttpSession session) {

        Integer count = 0;

        if(session.getAttribute("count")==null) {
            session.setAttribute("count", 0);
        }else {
            count = (Integer) session.getAttribute("count");
            count++;
            session.setAttribute("count", count);
        }

        return "index.jsp";
    }

    @RequestMapping("/counter")
    public String counter() {
        return "counter.jsp";
    }
}