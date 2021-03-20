package pl.sda.javalondek4springdemo.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Team {

    public final Player whichPlayer;

    public Team(@Qualifier("buffon") Player whichPlayer) {
        System.out.println("Injected class: " + whichPlayer.getClass());
        this.whichPlayer = whichPlayer;
    }



}
