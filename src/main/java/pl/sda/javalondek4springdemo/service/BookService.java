package pl.sda.javalondek4springdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.sda.javalondek4springdemo.converter.BookMapper;
import pl.sda.javalondek4springdemo.dto.BookDto;
import pl.sda.javalondek4springdemo.exception.BookNotFoundException;
import pl.sda.javalondek4springdemo.model.Book;
import pl.sda.javalondek4springdemo.repository.BookRepository;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<Book> findAllBooks() {

        var result = bookRepository.findAllBooks();

        logger.info("number of found books: [{}]", result.size());
        logger.debug("result: {}", result);

        return result;
    }

    public Book findBookById(Long id) {
        Objects.requireNonNull(id, "id parameter mustn't be null!!!");

        var result = findBookByIdFromRepository(id);
        logger.info("book found for id: [{}] is: [{}]", id, result);

        return result;
    }

    private Book findBookByIdFromRepository(Long id) {
        return bookRepository.findAllBooks()
            .stream()
            .filter(book -> book.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new BookNotFoundException(String.format("No book with id:[%d]", id)));
    }

    public Book saveBook(Book toSave) {

        // find max id
        // add book with id (max id + 1)
        // return book with id
        Long currentMaxId = bookRepository.findAllBooks()
            .stream()
            .mapToLong(value -> value.getId())
            .max()
            .orElse(1);
        toSave.setId(currentMaxId + 1);
        bookRepository.findAllBooks().add(toSave);

        logger.info("saved book: [{}]", toSave);

        return toSave;
    }

    public boolean deleteBookById(Long id) {
        boolean result = bookRepository.deleteBookWithId(id);
        logger.info("trying to delete book with id: [{}], result: [{}]", id, result);
        return result;
    }

    // Transactional
    public Book replaceBook(Long id, Book toReplace) {
        Book book = findBookByIdFromRepository(id);

        toReplace.setId(id);
        bookRepository.findAllBooks().removeIf(book1 -> book1.getId().equals(id));
        bookRepository.findAllBooks().add(toReplace);

        logger.info("replacing book [{}] with new one [{}]", book, toReplace);
        return toReplace;
    }

    public Book updateBookWithAttributes(Long id, BookDto toUpdate) {

        Book bookEntityToUpdate = bookMapper.fromDtoToEntity(toUpdate);
        Book book = findBookByIdFromRepository(id);


        if (nonNull(bookEntityToUpdate.getName())) {
            book.setName(bookEntityToUpdate.getName());
        }

        if (nonNull(bookEntityToUpdate.getSurname()))
            book.setSurname();

        if (nonNull(toUpdate.getTitle())) {
            book.setTitle(toUpdate.getTitle());
        }

        logger.info("updated book: [{}], with changes to apply: [{}]", book, toUpdate);
        return book;
    }
}
