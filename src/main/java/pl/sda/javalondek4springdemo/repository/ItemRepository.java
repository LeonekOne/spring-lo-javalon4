package pl.sda.javalondek4springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.javalondek4springdemo.model.Item;

import java.util.List;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {

     List<Item> findItemByCategory_Name(String name);

     List<Item> findItemByPriceBetween(Double from, Double to);
}
