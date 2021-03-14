package pl.sda.javalondek4springdemo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.javalondek4springdemo.model.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private static final Logger logger = LoggerFactory.getLogger(BookRepository.class);

    private final BookCrudRepository bookCrudRepository;

    public BookRepository(BookCrudRepository bookCrudRepository) {
        this.bookCrudRepository = bookCrudRepository;
    }

    public List<Book> findAllBooks() {

        var result = bookCrudRepository.findAllBooks();
        logger.info("number of found books: [{}]", result.size());
        logger.debug("found books: {}", result);
        return result;
    }

    @Transactional
    public boolean deleteBookWithId(Long id) {
        boolean exists = bookCrudRepository.existsById(id);
        if (exists) {
            bookCrudRepository.deleteById(id);
        }

        return exists;
    }
}
