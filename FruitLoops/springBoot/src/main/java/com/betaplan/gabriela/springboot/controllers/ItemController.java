package com.betaplan.gabriela.springboot.controllers;


import com.betaplan.gabriela.springboot.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

// ... imports (Use shift+ctrl+O or shift+cmd+O to import as you code)
@Controller
public class ItemController {

    @RequestMapping("/")
    public String index(Model model) {

        ArrayList<Item> fruits = new ArrayList<Item>();
        fruits.add(new Item("Kiwi", 1.5));
        fruits.add(new Item("Mango", 2.0));
        fruits.add(new Item("Goji Berries", 4.0));
        fruits.add(new Item("Guava", .75));

        // Add fruits your view model here
        model.addAttribute("fruits",fruits);

        return "index.jsp";
    }
}
