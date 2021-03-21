package pl.sda.javalondek4springdemo.model.onetoone.bidirectional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
// Columns in db:
// ID, NAME, MY_OWNER_ID
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    // @JoinColumn attributes
    // name - name of foreign key in CAT table
    // referencedColumnName - name of primary key from OWNER table
    @JoinColumn(name = "MY_OWNER_ID", referencedColumnName = "IDENTIFIER")
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
