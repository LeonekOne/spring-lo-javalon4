package pl.sda.javalondek4springdemo.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "CATEGORIES")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Item> itemList;

    public Category(String name, List<Item> itemList) {
        this.name = name;
        this.itemList = itemList;
    }

    public Category() {
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
