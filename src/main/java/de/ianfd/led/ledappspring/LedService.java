package de.ianfd.led.ledappspring;
/*
 * Created by ian on 26.01.21
 * Location: de.ianfd.led.ledappspring
 * Created for the project ledapp-spring with the name LedService
 */

import com.github.mbelling.ws281x.LedStripType;
import com.github.mbelling.ws281x.Ws281xLedStrip;
import de.ianfd.led.ledappspring.effects.BasicEffect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class LedService {

    private BasicEffect basicEffect = null;
    private Ws281xLedStrip led;
    private final Logger log = Logger.getLogger(LedScheduler.class.getName());

    @Autowired
    public LedService() {
        this.led = new Ws281xLedStrip(40, // led count
                18, // GPIO pin, must support pwm
                800000, //frequency
                10, //DMA, see also https://github.com/jgarff/rpi_ws281x/issues/224
                100, //brightness
                0, //pwm channel, GPIO 18 supports PWM0
                false, //invert
                LedStripType.WS2811_STRIP_RGB,
                true); // clear on exit
    }

    public void setEffect(BasicEffect newEffect) {
        log.info("Setting new effect active: " + newEffect.getName());
        this.basicEffect = newEffect;
    }

    public BasicEffect getCurrentEffect() {
        return basicEffect;
    }

    public Ws281xLedStrip getLed() {
        return led;
    }

}
