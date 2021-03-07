package pl.sda.javalondek4springdemo.model;



public class Book {

    private Long id;

    private String name;

    private String surname;


    private String title;

    public Book(Long id, String name, String surname, String title) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.title = title;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
            "id=" + id +
            ", title='" + title + '\'' +
            '}';
    }
}
