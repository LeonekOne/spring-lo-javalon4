package pl.sda.javalondek4springdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.sda.javalondek4springdemo.model.Book;
import pl.sda.javalondek4springdemo.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    //TODO kolejnosc budowania aplikacji
    // dtos
    // exceptions
    // baza entities
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    // albo to: @GetMapping("/")
    public List<Book> getAllBooks() {
        logger.info("getAllBooks()");
        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        logger.info("find book by id: [{}]", id);
        return bookService.findBookById(id);
    }

    @PostMapping
    public void addBook(@RequestBody Book toSave) {
        logger.info("adding book: [{}]", toSave);

        bookService.saveBook(toSave);

    }

}
