package pl.sda.javalondek4springdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstRestController {

    @GetMapping("/say-something")
    public String saySomething() {
        return "Hello REST :)";
    }
}
