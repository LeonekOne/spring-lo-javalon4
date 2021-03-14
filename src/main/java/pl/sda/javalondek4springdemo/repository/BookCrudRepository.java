package pl.sda.javalondek4springdemo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.javalondek4springdemo.model.Book;

public interface BookCrudRepository extends CrudRepository<Book, Long> {


}
