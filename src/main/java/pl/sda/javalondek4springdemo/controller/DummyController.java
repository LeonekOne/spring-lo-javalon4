package pl.sda.javalondek4springdemo.controller;

import pl.sda.javalondek4springdemo.service.DummyService;

public class DummyController {

    private final DummyService dummyService;

    public DummyController(DummyService dummyService) {
        this.dummyService = dummyService;
    }
}
