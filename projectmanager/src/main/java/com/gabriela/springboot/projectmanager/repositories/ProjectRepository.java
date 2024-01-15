package com.gabriela.springboot.projectmanager.repositories;

import com.gabriela.springboot.projectmanager.models.Project;
import com.gabriela.springboot.projectmanager.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    List<Project> findAll();
    Project findByIdIs(Long id);
    List<Project> findAllByUsers(User user);
    List<Project> findByUsersNotContains(User user);
}