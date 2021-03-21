package pl.sda.javalondek4springdemo.repository.onetomany;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import pl.sda.javalondek4springdemo.model.onetomany.bidirectional.Owner;

@Profile("onetomany-bidirectional")
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
