package pl.sda.javalondek4springdemo.service.crypto;

import org.springframework.stereotype.Service;

@Service
public class CryptoOperations {

    private final HsmModule hsmModule;

    public CryptoOperations(HsmModule hsmModule) {
        this.hsmModule = hsmModule;
    }
}
