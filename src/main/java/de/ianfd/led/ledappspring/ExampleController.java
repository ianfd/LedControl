package de.ianfd.led.ledappspring;
/*
 * Created by ian on 26.01.21
 * Location: de.ianfd.led.ledappspring
 * Created for the project ledapp-spring with the name ExampleController
 */

import de.ianfd.led.ledappspring.effects.Colorspinner;
import de.ianfd.led.ledappspring.effects.RunningRainbowEffect;
import de.ianfd.led.ledappspring.effects.StaticRainbowEffect;
import de.ianfd.led.ledappspring.effects.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    private LedService ledService;

    @Autowired
    public ExampleController(LedService ledService) {
        this.ledService = ledService;
    }

    @GetMapping("/start")
    @ResponseBody
    public ResponseEntity<String> startEffect() {
        ledService.setEffect(new StaticRainbowEffect("Rainbow Effect", 3, new Utils()));
        return ResponseEntity.status(HttpStatus.OK).body("Alles supi, look at this");
    }

    @GetMapping("/wheel")
    @ResponseBody
    public ResponseEntity<String> wheelEffect() {
        ledService.setEffect(new Colorspinner("Wheel Effect", 1, new Utils()));
        return ResponseEntity.status(HttpStatus.OK).body("Alles supi, look at this222222");
    }

    @GetMapping("/superwheel")
    @ResponseBody
    public ResponseEntity<String> superWheelEffect() {
        ledService.setEffect(new RunningRainbowEffect("Super Wheel Effect", 2, new Utils()));
        return ResponseEntity.status(HttpStatus.OK).body("Alles supi, look at this33333");
    }
}
