package pl.sda.javalondek4springdemo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.sda.javalondek4springdemo.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookCrudRepository extends CrudRepository<Book, Long> {

    @Query("from books")
//    @Query("" +
//            "select b                           " +
//            "books from books b                 ")
    List<Book> findAllBooks();

    Optional<Book> findBookByTitle(String title);
}
