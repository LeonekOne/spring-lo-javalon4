package pl.sda.javalondek4springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.javalondek4springdemo.controller.MyFirstRestController;
import pl.sda.javalondek4springdemo.repository.MyRepository;
import pl.sda.javalondek4springdemo.service.MyService;

@SpringBootApplication
public class JavaLondek4SpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaLondek4SpringDemoApplication.class, args);
    }


    public static void dependencyInjectionFAQ() {
        MyRepository myRepository = new MyRepository();
        MyService myService = new MyService(myRepository); // dependency injection
        MyFirstRestController myFirstRestController = new MyFirstRestController(myService);
    }
}
