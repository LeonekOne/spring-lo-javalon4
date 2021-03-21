package pl.sda.javalondek4springdemo.model.onetoone.bidirectional;

import org.springframework.context.annotation.Profile;

import javax.persistence.*;

@Profile("onetoone-bidirectional")
@Entity
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private Owner owner;

    public Cat() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
