package pl.sda.javalondek4springdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstRestController {

    private static final Logger logger = LoggerFactory.getLogger(MyFirstRestController.class);

    @GetMapping("/say-something")
    public String saySomething() {

        // logging levels
        // trace
        // debug
        // info <-- current level
        // warn --
        // error -- inside cath
        logger.info("/say-something");
        logger.debug("is it visible???");
        logger.trace("and this???");
        return "hello rest:P";
    }
}
