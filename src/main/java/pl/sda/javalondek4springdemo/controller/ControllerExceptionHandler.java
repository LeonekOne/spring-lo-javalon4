package pl.sda.javalondek4springdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.sda.javalondek4springdemo.dto.ExceptionResponse;
import pl.sda.javalondek4springdemo.exception.BookNotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.time.Clock;
import java.time.LocalDate;

@RestControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleBookNotFoundException(Exception exception, HttpServletRequest request) {
        logger.warn("generic exception handler for some unexpected exception has occurred", exception);
        return ResponseEntity.badRequest().body(
                new ExceptionResponse(LocalDate.now(Clock.systemUTC()),
                        HttpStatus.BAD_REQUEST.value(),
                        exception.getClass().getName(),
                        exception.getMessage(),
                        request.getServletPath()
                )
        );
    }
}
