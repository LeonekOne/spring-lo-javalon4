package pl.sda.javalondek4springdemo.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ITEMS")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    @Column
    private Double price;

    @Column
    private String name;

    public Item(Category category, Double price, String name) {
        this.category = category;
        this.price = price;
        this.name = name;
    }

    public Item() {
    }

    public UUID getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", category=" + category +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
