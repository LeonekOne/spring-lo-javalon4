package pl.sda.javalondek4springdemo.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("buffon")
@Primary
public class Goalkeeper implements Player {

    @Override
    public void play() {
        System.out.println("I'm goalkeeper");
    }
}
