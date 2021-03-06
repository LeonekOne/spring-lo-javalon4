package pl.sda.javalondek4springdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.javalondek4springdemo.model.Book;
import pl.sda.javalondek4springdemo.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    // TODO: kolejność budowania aplikacji - kroki:)
    // dtos
    // exceptions
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
    public Book addBook(@RequestBody Book toSave) {
        logger.info("adding book: [{}]", toSave);

        return bookService.saveBook(toSave);
    }
}
