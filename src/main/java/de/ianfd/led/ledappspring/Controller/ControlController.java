package de.ianfd.led.ledappspring.Controller;
/*
 * Created by ian on 26.01.21
 * Location: de.ianfd.led.ledappspring.Controller
 * Created for the project ledapp-spring with the name ControlController
 * What a name xD
 */

import de.ianfd.led.ledappspring.LedService;
import de.ianfd.led.ledappspring.effects.*;
import de.ianfd.led.ledappspring.model.CometModel;
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
        SolidColorEffect solidColor = new SolidColorEffect("Solid Color", 500);
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

    @PostMapping("/comet")
    @ResponseBody
    public ResponseEntity<String> setComet(@RequestBody CometModel cometModel) {
        CometEffect cometEffect = new CometEffect("Comet Effect", cometModel.getSpeed());
        cometEffect.setTailLength(cometModel.getTailLength());
        System.out.println("Brightness: " + cometModel.getBrightness() + " / Tail length: " + cometModel.getTailLength() + " / Speed: " + cometModel.getSpeed() + " / Red: " + cometModel.getCometR() +
                " / Green: " + cometModel.getCometG() + " / Blue: " + cometModel.getCometB());
        cometEffect.setHeadColor(cometModel.getCometR(), cometModel.getCometG(), cometModel.getCometB());
        cometEffect.setBackgroundColor(cometModel.getBgR(), cometModel.getBgG(), cometModel.getBgB(), cometModel.getBackgroundBrightness());
        cometEffect.setMaxBrightness(cometModel.getBrightness()); // brightness ranges from 0-255
        ledService.setEffect(cometEffect);
        return ResponseEntity.status(HttpStatus.OK).body("successful");
    }

    @PostMapping("/clear")
    @ResponseBody
    public ResponseEntity<String> clearEffects() {
        ledService.clearEffects();
        return ResponseEntity.status(HttpStatus.OK).body("successful");
    }

    @GetMapping("/getcurrenteffect")
    public ResponseEntity<String> getCurrentEffect() {
        String name = "n/a";
        if (ledService.getCurrentEffect() != null) {
            name = ledService.getCurrentEffect().getName();
        }
        return ResponseEntity.status(HttpStatus.OK).body(name);
    }


}
