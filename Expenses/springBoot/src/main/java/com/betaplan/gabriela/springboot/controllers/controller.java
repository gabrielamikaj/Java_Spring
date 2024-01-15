
package com.betaplan.gabriela.springboot.controllers;
import com.betaplan.gabriela.springboot.models.Expenses;
import com.betaplan.gabriela.springboot.services.service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class controller {
    @Autowired
    service expenseService;



    @GetMapping("/")
    public String home() {
        return "redirect:/expenses";
    }

    @GetMapping("/expenses")
    public String index(@ModelAttribute("expense") Expenses expense, Model model) {
        List<Expenses> expenses = expenseService.allExpenses();
        model.addAttribute("expenses", expenses);


        return "index";
    }

    @PostMapping("/expenses")
    public String index(@Valid @ModelAttribute("expense") Expenses expense, BindingResult result, Model model) {
        if(result.hasErrors()) {
            List<Expenses> expenses = expenseService.allExpenses();
            model.addAttribute("expenses", expenses);
            return "index";
        }else {
            expenseService.createExpense(expense);
            return "redirect:/expenses";
        }
    }

    @GetMapping("/expenses/update/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("expense", expenseService.findExpense(id));
        return "edit";
    }

    @PutMapping ("/expenses/edit/{id}")
    public String update(
            @PathVariable("id") Long id,
            Model model,
            @Valid @ModelAttribute("expense") Expenses expense,
            BindingResult result) {
        if(result.hasErrors()) {
            model.addAttribute("expense", expenseService.findExpense(id));
            return "redirect:/expenses/update/{id}";
        }else {
            expenseService.updateExpense(expense);
            return "redirect:/expenses";
        }
    }

    @GetMapping("/expenses/{id}")
    public String showExpense(@PathVariable("id") Long id, Model model) {
        model.addAttribute("expense", expenseService.findExpense(id));
        return "show";
    }

    @RequestMapping("/expenses/delete/{id}")
    public String deleteExpense(@PathVariable("id") Long id) {
        Expenses expense = expenseService.findExpense(id);
        expenseService.deleteExpense(expense);
        return "redirect:/expenses";
    }

}
