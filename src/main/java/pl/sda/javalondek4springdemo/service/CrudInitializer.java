package pl.sda.javalondek4springdemo.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.javalondek4springdemo.model.Address;
import pl.sda.javalondek4springdemo.model.Course;
import pl.sda.javalondek4springdemo.model.Teacher;
import pl.sda.javalondek4springdemo.repository.CourseRepository;
import pl.sda.javalondek4springdemo.repository.TeacherRepository;
import java.util.ArrayList;
import java.util.List;
@Component
public class CrudInitializer implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CrudInitializer.class);
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    public CrudInitializer(TeacherRepository teacherRepository, CourseRepository courseRepository) {
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
    }
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // create one course
        Course java = new Course();
        java.setCourseName("java 101");
        // create one teacher
        Teacher teacher = new Teacher();
        teacher.setAddress(new Address("warszawa", "rzecz", 102L));
        List<Course> courseList = new ArrayList<>();
        courseList.add(java);
        teacher.setCourseList(courseList);
        java.setTeacher(teacher);
        // save it:)
        teacher = teacherRepository.save(teacher);
        logger.info("Saved teacher: " + teacher);
//        courseRepository.save(java);
        logger.info("All teachers from db:");
        teacherRepository.findAll()
                .forEach(teacher1 -> logger.info("teacher from db: " + teacher1));
    }
}