package com.gabriela.springboot.bookclub.repositories;

import com.gabriela.springboot.bookclub.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAll();
}