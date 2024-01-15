package com.gabriela.springboot.categoryproduct.repositories;


import com.gabriela.springboot.categoryproduct.models.Category;
import com.gabriela.springboot.categoryproduct.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
    Product findByIdIs(Long id);
    List<Product> findAllByCategories(Category category);
    List<Product> findByCategoriesNotContains(Category category);
}