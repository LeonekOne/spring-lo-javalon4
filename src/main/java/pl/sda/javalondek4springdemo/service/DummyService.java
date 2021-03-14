package pl.sda.javalondek4springdemo.service;

import pl.sda.javalondek4springdemo.repository.DummyRepository;

public class DummyService {

    private final DummyRepository dummyRepository;

    public DummyService(DummyRepository dummyRepository) {
        this.dummyRepository = dummyRepository;
    }
}
