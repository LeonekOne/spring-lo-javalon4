package pl.sda.javalondek4springdemo.model.onetoone.bidirectional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.sda.javalondek4springdemo.repository.onetoone.bidirectional.CatRepository;
import pl.sda.javalondek4springdemo.repository.onetoone.bidirectional.OwnerRepository;

@Profile("onetoone-birectional")
@Component
public class OneToOneBidirectionalExample implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(OneToOneBidirectionalExample.class);

    private final OwnerRepository ownerRepository;

    private final CatRepository catRepository;

    public OneToOneBidirectionalExample(OwnerRepository ownerRepository, CatRepository catRepository) {
        this.ownerRepository = ownerRepository;
        this.catRepository = catRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner me = new Owner();
        me.setFirstName("maniek");
        me.setLastName("p.");

        Cat mruczek = new Cat();
        mruczek.setName("mruczek");

        // this commented source code can be used only when there's no cascade!!!
//        catRepository.save(mruczek);
//        logger.info("mruczek was saved to db with id: [{}]", mruczek.getId());
////
//        me.setCat(mruczek);
//        ownerRepository.save(me);
//
//        mruczek.setOwner(me);
//        catRepository.save(mruczek);
//        // saving without cascade is nightmare, but sometimes is necessary :(

        Owner olaf = new Owner();
        olaf.setFirstName("olaf");
        olaf.setLastName("l");

        Cat łobuz = new Cat();
        łobuz.setName("lobuz");
        łobuz.setOwner(olaf);
        olaf.setCat(łobuz);

        ownerRepository.save(olaf);
    }
}
