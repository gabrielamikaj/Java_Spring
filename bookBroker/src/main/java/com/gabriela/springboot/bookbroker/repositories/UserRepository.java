package com.gabriela.springboot.bookbroker.repositories;
import com.gabriela.springboot.bookbroker.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();
    Optional<User> findByEmail(String email);
}