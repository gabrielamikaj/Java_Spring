package com.betaplan.gabriela.springboot.services;

import com.betaplan.gabriela.springboot.models.Expenses;
import com.betaplan.gabriela.springboot.repositories.repo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class service {
    private final repo expenseRepository;

    public service(repo expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expenses> allExpenses(){
        return expenseRepository.findAll();
    }

    public Expenses createExpense(Expenses expense) {
        return expenseRepository.save(expense);
    }

    public Expenses findExpense(Long id) {
        Optional<Expenses> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        }else {
            return null;
        }
    }

    public Expenses updateExpense(Expenses expense) {
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Expenses expense) {
        expenseRepository.delete(expense);
    }

}