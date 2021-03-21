package pl.sda.javalondek4springdemo.model.onetomany.bidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

// Columns in db:
// ID, FIRST_NAME, LAST_NAME, CAT_ID
@Entity(name = "OwnersWithManyCats")
@Table(name = "OWNERS_WITH_MANY_CATS")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identifier;

    private String firstName;

    private String lastName;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "owner")
    private List<Cat> cat;

    public Owner() {
    }

    public Long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Long id) {
        this.identifier = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Cat> getCat() {
        return cat;
    }

    public void setCat(List<Cat> cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "identifier=" + identifier +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cat=" + cat +
                '}';
    }
}
