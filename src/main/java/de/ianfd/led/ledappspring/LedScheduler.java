package de.ianfd.led.ledappspring;
/*
 * Created by ian on 26.01.21
 * Location: de.ianfd.led.ledappspring
 * Created for the project ledapp-spring with the name LedScheduler
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LedScheduler {

    private LedService ledService;

    @Autowired
    public LedScheduler(LedService ledService) {
        this.ledService = ledService;
    }

    @Scheduled(fixedDelayString = "10")
    public void runLed() {
        if (ledService.getCurrentEffect() != null) {
            System.out.println("LED EFFECT -> " + ledService.getCurrentEffect().getName());
            ledService.getCurrentEffect().executeTask(ledService.getLed());
        }
    }


}
