package pl.sda.javalondek4springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.javalondek4springdemo.model.Category;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
