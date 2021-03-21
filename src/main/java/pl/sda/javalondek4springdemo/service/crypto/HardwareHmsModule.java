package pl.sda.javalondek4springdemo.service.crypto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"prod", "test"})
@Service
public class HardwareHmsModule implements HsmModule, CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(HardwareHmsModule.class);

    @Override
    public String encryptPassword(String password) {
        logger.info("very complex operation with real HSM device");
        logger.info("trying to connect to real device...");
        return null;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("hsm module: [{}]", HardwareHmsModule.class.getSimpleName());
    }
}
