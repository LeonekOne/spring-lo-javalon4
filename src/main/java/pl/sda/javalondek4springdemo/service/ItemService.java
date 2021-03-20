package pl.sda.javalondek4springdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.sda.javalondek4springdemo.converter.CategoryMapper;
import pl.sda.javalondek4springdemo.converter.ItemMapper;
import pl.sda.javalondek4springdemo.dto.CategoryDto;
import pl.sda.javalondek4springdemo.dto.ItemDto;
import pl.sda.javalondek4springdemo.repository.CategoryRepository;
import pl.sda.javalondek4springdemo.repository.ItemRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final ItemMapper itemMapper;
    private final Logger logger = LoggerFactory.getLogger(ItemService.class);

    public ItemService(ItemRepository itemRepository, CategoryRepository categoryRepository, CategoryMapper categoryMapper, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.itemMapper = itemMapper;
    }

    public List<CategoryDto> getAllCategories() {

        return categoryRepository.findAll().stream()
                .map(category -> categoryMapper.fromEntityToDto(category))
                .collect(Collectors.toList());

    }

    public List<ItemDto> getAllItemsByCategory(String name) {
        return itemRepository.findItemByCategory_Name(name).stream()
                .map(item -> itemMapper.fromEntityToDto(item))
                .collect(Collectors.toList());
    }

    public List<ItemDto> getItemsInPriceRange(Double from, Double to) {

        return itemRepository.findItemByPriceBetween(from, to).stream()
                .map(item -> itemMapper.fromEntityToDto(item))
                .collect(Collectors.toList());
    }
}
