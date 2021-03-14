package pl.sda.javalondek4springdemo.service;

import pl.sda.javalondek4springdemo.repository.DummyRepository;

public class SecondDummyService {

    private final DummyRepository dummyRepository;

    public SecondDummyService(DummyRepository dummyRepository) {
        this.dummyRepository = dummyRepository;
    }
}
