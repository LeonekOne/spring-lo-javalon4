package pl.sda.javalondek4springdemo.dto;

import java.util.List;
import java.util.UUID;

public class CategoryDto {

    private final UUID id;

    private final String name;

    private final List<ItemDto> itemDtoList;

    public CategoryDto(UUID id, String name, List<ItemDto> itemDtoList) {
        this.id = id;
        this.name = name;
        this.itemDtoList = itemDtoList;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ItemDto> getItemDtoList() {
        return itemDtoList;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", itemDtoList=" + itemDtoList +
                '}';
    }
}
