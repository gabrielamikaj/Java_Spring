package com.gabriela.springboot.studentroaster.services;

import java.util.List;
import java.util.Optional;

import com.gabriela.springboot.studentroaster.models.Dorm;
import com.gabriela.springboot.studentroaster.repositories.DormRepository;
import org.springframework.stereotype.Service;


@Service
public class DormService {
    private final DormRepository dormRepo;

    public DormService(DormRepository dormRepo) {
        this.dormRepo = dormRepo;
    }

    public List<Dorm> allDorms(){
        return dormRepo.findAll();
    }

    public Dorm addDorm(Dorm dorm) {
        return dormRepo.save(dorm);
    }

    public Dorm findDorm(Long id) {
        Optional<Dorm> optionalDorm = dormRepo.findById(id);
        if(optionalDorm.isPresent()) {
            return optionalDorm.get();
        }else {
            return null;
        }
    }
}