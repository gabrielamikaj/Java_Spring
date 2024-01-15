package com.gabriela.springboot.categoryproduct.repositories;

        import com.gabriela.springboot.categoryproduct.models.Category;
        import com.gabriela.springboot.categoryproduct.models.Product;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;
        import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
    Category findByIdIs(Long id);
    List<Category> findAllByProducts(Product product);
    List<Category> findByProductsNotContains(Product product);
}