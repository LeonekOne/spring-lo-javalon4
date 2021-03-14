package pl.sda.javalondek4springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.javalondek4springdemo.model.Book;

public interface BookJpaRepository extends JpaRepository<Book, Long> {
}
