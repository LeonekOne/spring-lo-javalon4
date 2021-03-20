package pl.sda.javalondek4springdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.javalondek4springdemo.dto.CategoryDto;
import pl.sda.javalondek4springdemo.dto.ItemDto;
import pl.sda.javalondek4springdemo.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;
    private final Logger logger = LoggerFactory.getLogger(ItemController.class);


    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {

        return ResponseEntity.ok().body(itemService.getAllCategories());

    }

    @GetMapping("/categories/{name}")
    public ResponseEntity<List<ItemDto>> getAllItemsByCategory(@PathVariable("name") String name) {

        return ResponseEntity.ok().body(itemService.getAllItemsByCategory(name));
    }

    @GetMapping()
    public ResponseEntity<List<ItemDto>> getAllItemsInPriceRange(@RequestParam("priceFrom") Double from,
                                                                 @RequestParam("priceTo") Double to) {

        return ResponseEntity.ok().body(itemService.getItemsInPriceRange(from, to));

    }
}
