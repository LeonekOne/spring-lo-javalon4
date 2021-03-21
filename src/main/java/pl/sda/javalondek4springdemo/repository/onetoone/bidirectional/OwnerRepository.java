package pl.sda.javalondek4springdemo.repository.onetoone.bidirectional;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import pl.sda.javalondek4springdemo.model.onetoone.bidirectional.Owner;

@Profile("onetoone-bidirectional")
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
