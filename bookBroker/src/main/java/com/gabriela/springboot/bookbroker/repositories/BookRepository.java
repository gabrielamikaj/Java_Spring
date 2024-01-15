package com.gabriela.springboot.bookbroker.repositories;


        import com.gabriela.springboot.bookbroker.models.Book;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;


@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAll();
}