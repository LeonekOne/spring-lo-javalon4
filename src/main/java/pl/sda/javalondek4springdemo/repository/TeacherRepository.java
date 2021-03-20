package pl.sda.javalondek4springdemo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.javalondek4springdemo.model.Teacher;

import java.util.UUID;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
