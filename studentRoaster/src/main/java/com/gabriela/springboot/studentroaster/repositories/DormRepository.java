package com.gabriela.springboot.studentroaster.repositories;

import java.util.List;

import com.gabriela.springboot.studentroaster.models.Dorm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DormRepository extends CrudRepository<Dorm, Long> {
    List<Dorm> findAll();
}