package de.ianfd.led.ledappspring.effects;
/*
 * Created by ian on 26.01.21
 * Location: de.ianfd.led.ledappspring.effects
 * Created for the project ledapp-spring with the name OngoingRainbowEffect
 */

import com.github.mbelling.ws281x.Ws281xLedStrip;

public class RunningRainbowEffect extends BasicEffect {

    private Utils utils;
    private int loop = 0;
    private int brightness = 0;


    public RunningRainbowEffect(String name, int delay, Utils utils) {
        super(name, delay);
        this.utils = utils;
    }

    @Override
    public void firstFrame(Ws281xLedStrip ws281xLedStrip) {

    }

    @Override
    public void runFrame(Ws281xLedStrip ws281xLedStrip) {
        if (loop >= 255) loop = 0;
        for (int i = 0; i < ws281xLedStrip.getLedsCount(); i++) {
            ws281xLedStrip.setPixel(i, utils.colorWheel((i + loop) % 255));
        }
        ws281xLedStrip.setBrightness(brightness);
        ws281xLedStrip.render();
        loop++;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }
}
