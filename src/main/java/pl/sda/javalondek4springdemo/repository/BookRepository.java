package pl.sda.javalondek4springdemo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import pl.sda.javalondek4springdemo.model.Book;
import pl.sda.javalondek4springdemo.service.MyService;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private static final Logger logger = LoggerFactory.getLogger(BookRepository.class);

    private List<Book> books;

    public BookRepository() {
        List<Book> someBooks = List.of(
            new Book(1L, "Henryk Sienkiewicz", "Potop"),
            new Book(2L, "Adam Mickiewicz", "Pan Tadeusz"),
            new Book(3L, "Prus", "Lalka")
        );

        this.books = new ArrayList<>(someBooks);

        logger.info("book repository initialized with books: {}", books);
    }


    public List<Book> findAllBooks() {
        return books;
    }
}
