package pl.sda.javalondek4springdemo.repository.onetomany;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import pl.sda.javalondek4springdemo.model.onetomany.bidirectional.Cat;

@Profile("onetomany-bidirectional")
public interface CatRepository extends CrudRepository<Cat, Long> {
}
