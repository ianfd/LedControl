package de.ianfd.led.ledappspring.Controller;
/*
 * Created by ian on 26.01.21
 * Location: de.ianfd.led.ledappspring.Controller
 * Created for the project ledapp-spring with the name ControllController
 * What a name xD
 */

import de.ianfd.led.ledappspring.LedService;
import de.ianfd.led.ledappspring.effects.RunningRainbowEffect;
import de.ianfd.led.ledappspring.effects.SolidColor;
import de.ianfd.led.ledappspring.effects.StaticRainbowEffect;
import de.ianfd.led.ledappspring.effects.Utils;
import de.ianfd.led.ledappspring.model.RunningRainbowModel;
import de.ianfd.led.ledappspring.model.StaticColorModel;
import de.ianfd.led.ledappspring.model.StaticRainbowModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/control")
public class ControlController {

    private LedService ledService;

    @Autowired
    public ControlController(LedService ledService) {
        this.ledService = ledService;
    }

    @PostMapping("/staticcolor")
    @ResponseBody
    public ResponseEntity<String> setStaticColor(@RequestBody StaticColorModel staticColorModel) {
        SolidColor solidColor = new SolidColor("Solid Color", 500);
        solidColor.setColor(staticColorModel.getR(), staticColorModel.getG(), staticColorModel.getB(), staticColorModel.getBrightness());
        ledService.setEffect(solidColor);
        return ResponseEntity.status(HttpStatus.OK).body("successful");
    }

    @PostMapping("/runningrainbow")
    @ResponseBody
    public ResponseEntity<String> setRunningRainbow(@RequestBody RunningRainbowModel runningRainbowModel) {
        RunningRainbowEffect runningRainbowEffect = new RunningRainbowEffect("Running Rainbow", runningRainbowModel.getSpeed(), new Utils());
        runningRainbowEffect.setBrightness(runningRainbowModel.getBrightness());
        ledService.setEffect(runningRainbowEffect);
        return ResponseEntity.status(HttpStatus.OK).body("successful");
    }

    @PostMapping("/staticrainbow")
    @ResponseBody
    public ResponseEntity<String> setStaticRainbow(@RequestBody StaticRainbowModel staticRainbowModel) {
        StaticRainbowEffect staticRainbowEffect = new StaticRainbowEffect("Static Rainbow", staticRainbowModel.getSpeed(), new Utils());
        staticRainbowEffect.setBrightness(staticRainbowModel.getBrightness());
        ledService.setEffect(staticRainbowEffect);
        return ResponseEntity.status(HttpStatus.OK).body("successful");
    }


}
