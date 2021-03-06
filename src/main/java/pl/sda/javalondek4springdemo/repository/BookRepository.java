package pl.sda.javalondek4springdemo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import pl.sda.javalondek4springdemo.model.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private static final Logger logger = LoggerFactory.getLogger(BookRepository.class);

    private List<Book> books;

    public BookRepository() {
        List<Book> someBooks = List.of(
            new Book(1L, "Henryk Sienkiewicz", "Potop"),
            new Book(2L, "Henryk Sienkiewicz", "Pan Wołodyjowski"),
            new Book(3L, "Henryk Sienkiewicz", "Quo Vadis")
        );

        this.books = new ArrayList<>(someBooks);

        logger.info("book repository initialized with books: {}", books);
    }


    public List<Book> findAllBooks() {

        return books;
    }

    public boolean deleteBookWithId(Long id) {
        return books.removeIf(book -> book.getId().equals(id));
    }
}
