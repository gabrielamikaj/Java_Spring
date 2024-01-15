package com.betaplan.gabriela.springboot.repositories;

import java.util.List;

import com.betaplan.gabriela.springboot.models.Expenses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface repo extends CrudRepository<Expenses, Long> {
    List<Expenses> findAll();
}