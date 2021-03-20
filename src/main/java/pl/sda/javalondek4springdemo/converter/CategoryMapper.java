package pl.sda.javalondek4springdemo.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.javalondek4springdemo.dto.CategoryDto;
import pl.sda.javalondek4springdemo.model.Category;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper implements Mapper<Category, CategoryDto> {

    private ItemMapper itemMapper;

//    public CategoryMapper(ItemMapper itemMapper) {
//        this.itemMapper = itemMapper;
//    }


    public CategoryMapper() {
        // empty
    }

//    @Autowired
    public void setItemMapper(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public CategoryDto fromEntityToDto(Category entity) {
        return new CategoryDto(entity.getId(), entity.getName(),
                entity.getItemList().stream()
                .map(item -> itemMapper.fromEntityToDto(item))
                .collect(Collectors.toList())
        );
    }

    @Override
    public Category fromDtoToEntity(CategoryDto dto) {
        return null;
    }
}
