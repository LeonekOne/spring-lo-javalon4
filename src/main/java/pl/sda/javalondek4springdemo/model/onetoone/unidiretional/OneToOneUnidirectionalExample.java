package pl.sda.javalondek4springdemo.model.onetoone.unidiretional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.sda.javalondek4springdemo.repository.onetoone.CatRepository;
import pl.sda.javalondek4springdemo.repository.onetoone.OwnerRepository;

@Profile("onetoone-unidirectional")
@Component
public class OneToOneUnidirectionalExample implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(OneToOneUnidirectionalExample.class);

    private final OwnerRepository ownerRepository;

    private final CatRepository catRepository;

    public OneToOneUnidirectionalExample(OwnerRepository ownerRepository, CatRepository catRepository) {
        this.ownerRepository = ownerRepository;
        this.catRepository = catRepository;
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
