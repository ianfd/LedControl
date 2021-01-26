package de.ianfd.led.ledappspring.effects;
/*
 * Created by ian on 26.01.21
 * Location: de.ianfd.led.ledappspring.effects
 * Created for the project ledapp-spring with the name Colorspinner
 */

import com.github.mbelling.ws281x.Color;
import com.github.mbelling.ws281x.Ws281xLedStrip;


public class Colorspinner extends BasicEffect {

    private Utils utils;
    private int currentPos = 0;
    private int brightness = 125;

    public Colorspinner(String name, int delay, Utils utils) {
        super(name, delay);
        this.utils = utils;
    }

    @Override
    public void firstFrame(Ws281xLedStrip ws281xLedStrip) {

    }

    @Override
    public void runFrame(Ws281xLedStrip ws281xLedStrip) {
        if (currentPos >= ws281xLedStrip.getLedsCount()) currentPos = 0;
        Color c = utils.colorWheel(currentPos + 200);
        ws281xLedStrip.setPixel(currentPos, c);
        System.out.println("rendering!");
        ws281xLedStrip.render();
        currentPos++;
    }

}
