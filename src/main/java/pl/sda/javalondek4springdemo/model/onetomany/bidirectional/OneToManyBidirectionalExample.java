package pl.sda.javalondek4springdemo.model.onetomany.bidirectional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sda.javalondek4springdemo.repository.onetomany.CatRepository;
import pl.sda.javalondek4springdemo.repository.onetomany.OwnerRepository;

import java.util.List;

@Component
public class OneToManyBidirectionalExample implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(OneToManyBidirectionalExample.class);
    private final OwnerRepository ownerRepository;
    private final CatRepository catRepository;

    public OneToManyBidirectionalExample(OwnerRepository ownerRepository, CatRepository catRepository) {
        this.ownerRepository = ownerRepository;
        this.catRepository = catRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Cat white = new Cat();
        white.setName("white");

        Cat black = new Cat();
        black.setName("black");

        Owner stranger = new Owner();
        stranger.setFirstName("stranger");
        stranger.setCat(List.of(white, black));

        white.setOwner(stranger);
        black.setOwner(stranger);

        ownerRepository.save(stranger);

        ownerRepository.findAll()
                .forEach(owner -> logger.info("owner [{}] and cats: [{}]", owner, owner.getCat()));

    }
}