package pl.sda.javalondek4springdemo.repository.onetoone;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import pl.sda.javalondek4springdemo.model.onetoone.bidirectional.Owner;

@Profile({"onetoone-birectional", "onetoone-unidirectional"})
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
