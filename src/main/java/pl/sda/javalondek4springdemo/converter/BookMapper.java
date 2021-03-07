package pl.sda.javalondek4springdemo.converter;

import pl.sda.javalondek4springdemo.dto.BookDto;
import pl.sda.javalondek4springdemo.model.Book;

public class BookMapper implements Mapper<Book, BookDto> {

    @Override
    public BookDto fromEntityToDto(Book entity) {
        return new BookDto(entity.getId(), entity.getAuthor(), entity.getTitle());
    }

    @Override
    public Book fromDtoToEntity(BookDto dto) {
        return new Book(dto.getId(), dto.getAuthor(), dto.getTitle());
    }
}