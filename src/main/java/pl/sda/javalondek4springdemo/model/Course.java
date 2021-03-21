package pl.sda.javalondek4springdemo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COURSES")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    @ManyToOne(cascade = CascadeType.PERSIST)
    // SQL names - use upper cases
    // name = foreign key name in COURSES table (default: field_name + _ + ID -> TEACHER_ID)
    // use custom name when column in database has some non-javish name :)
    // referencedColumnName refers to primary key of Teacher
    @JoinColumn(referencedColumnName = "ID")
    private Teacher teacher;

    public Course() {
        // empty
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
            "id=" + id +
            ", courseName='" + courseName + '\'' +
            ", teacher=..." +
            '}';
    }
}
