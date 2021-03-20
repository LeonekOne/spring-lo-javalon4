package pl.sda.javalondek4springdemo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.javalondek4springdemo.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
