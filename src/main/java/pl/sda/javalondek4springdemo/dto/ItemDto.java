package pl.sda.javalondek4springdemo.dto;

import java.util.UUID;

public class ItemDto {

    private UUID id;
    private CategoryDto category;
    private Double price;
    private String name;

    public ItemDto(UUID id, CategoryDto category, Double price, String name) {
        this.id = id;
        this.category = category;
        this.price = price;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public CategoryDto getCategory() {
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
        return "ItemDto{" +
                "id=" + id +
                ", category=" + category +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
