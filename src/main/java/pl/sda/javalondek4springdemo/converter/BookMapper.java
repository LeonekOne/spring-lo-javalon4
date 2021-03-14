package pl.sda.javalondek4springdemo.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.sda.javalondek4springdemo.dto.BookDto;
import pl.sda.javalondek4springdemo.model.Book;

import static java.util.Objects.nonNull;

public class BookMapper implements Mapper<Book, BookDto> {

    private static final String space = " ";

    private static final Logger logger = LoggerFactory.getLogger(BookMapper.class);

    @Override
    public BookDto fromEntityToDto(Book entity) {

        var result = new BookDto(entity.getId(), entity.getName() + space + entity.getSurname(), entity.getTitle());
        logger.debug("converting entity: [{}] to dto: [{}]", entity, result);
        return result;
    }

    @Override
    public Book fromDtoToEntity(BookDto dto) {
        String authorNameAndSurname = dto.getAuthor();
        final int notFoundIndex = -1;
        int separatorIndex = nonNull(authorNameAndSurname) ? authorNameAndSurname.indexOf(space) : notFoundIndex;

        String name = "";
        String surname = "";
        if (separatorIndex == notFoundIndex) {
            surname = authorNameAndSurname;
        } else {
            name = authorNameAndSurname.substring(0, separatorIndex);
            surname = authorNameAndSurname.substring(separatorIndex + 1);
        }

        var result = new Book(dto.getId(), name, surname, dto.getTitle());

        logger.debug("converting from dto: [{}] to enity: [{}]", dto, result);
        return result;
    }
}
