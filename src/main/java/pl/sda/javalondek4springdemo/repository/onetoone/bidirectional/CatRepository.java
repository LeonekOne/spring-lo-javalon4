package pl.sda.javalondek4springdemo.repository.onetoone.bidirectional;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import pl.sda.javalondek4springdemo.model.onetoone.bidirectional.Cat;

@Profile("onetoone-birectional")
public interface CatRepository extends CrudRepository<Cat, Long> {
}
