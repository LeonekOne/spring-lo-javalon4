package pl.sda.javalondek4springdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.javalondek4springdemo.dto.ExceptionResponse;
import pl.sda.javalondek4springdemo.exception.BookNotFoundException;
import pl.sda.javalondek4springdemo.model.Book;
import pl.sda.javalondek4springdemo.service.BookService;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    // TODO: kolejność budowania aplikacji - kroki:)
    // dtos
    // baza - entities

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {

        logger.info("getAllBooks()");

        return bookService.findAllBooks();
    }

    // /books/1
    // /books/101
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        logger.info("find book by id: [{}]", id);

        return bookService.findBookById(id);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book toSave) {
        logger.info("adding book: [{}]", toSave);

        var newBook = bookService.saveBook(toSave);

        return ResponseEntity.created(URI.create("books/" + newBook.getId()))
            .body(newBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable("id") Long id) {
        logger.info("deleting book by id: [{}]", id);
        // delete true - RC 204
        // delete false - RC 4xx
        boolean deleted = bookService.deleteBookById(id);
        ResponseEntity<Void> result = ResponseEntity.notFound().build();
        if (deleted) {
            return ResponseEntity.noContent().build();
        }

        return result;

//        return deleted ?  ResponseEntity.noContent().build() : ResponseEntity.notFound().build() ;
    }

    // update (replace)
    @PutMapping("/{id}")
    public Book replaceBook(@PathVariable("id") Long id, @RequestBody Book toReplace) {
        logger.info("replacing book with id: [{}] with new one: [{}]", id, toReplace);

        return bookService.replaceBook(id, toReplace);
    }

    // update (partial)
    @PatchMapping("/{id}")
    public Book updateBook(@PathVariable("id") Long id, @RequestBody Book toUpdate) {
        logger.info("updating book with id: [{}] with new attributes: [{}]", id, toUpdate);

        return bookService.updateBookWithAttributes(id, toUpdate);
    }

//    try {
//        all methods from current controller
//    } catch (BookNotFoundException exception) {
//
//    } catch (AnotherException exc) {
//
//    }
    // only for this controller
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleBookNotFoundException(Exception exception, HttpServletRequest request) {
        logger.warn("some unexpected exception has occurred:)", exception);


        return ResponseEntity.badRequest().body(
            new ExceptionResponse(LocalDateTime.now(Clock.systemUTC()),
                HttpStatus.BAD_REQUEST.value(),
                exception.getClass().getName(),
                exception.getMessage(),
                request.getServletPath()
            )
        );
    }
}
