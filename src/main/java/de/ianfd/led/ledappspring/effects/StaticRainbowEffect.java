package de.ianfd.led.ledappspring.effects;
/*
 * Created by ian on 26.01.21
 * Location: de.ianfd.led.effects.effects
 * Created for the project EffectLibRpiWs281X with the name SolidColor
 */

import com.github.mbelling.ws281x.Color;
import com.github.mbelling.ws281x.Ws281xLedStrip;

public class StaticRainbowEffect extends BasicEffect {

    // Effect description:
    // Delay between each frame ~50ms that translates to 5 as a value for delay
    // It takes about ~13 seconds to fully run this effect


    private int brightness = 255; // brightness ranges from 0-255 where 0 is black and 255 is blinding bright
    private Utils utils;
    private int pos = 0;

    public StaticRainbowEffect(String name, int delay, Utils utils) {
        super(name, delay);
        this.utils = utils;
    }

    @Override
    public void firstFrame(Ws281xLedStrip ws281xLedStrip) {
    }

    @Override
    public void runFrame(Ws281xLedStrip ws281xLedStrip) {
        if (pos >= 254) {
            pos = 0;
        }
        Color c = utils.colorWheel(pos);
        for (int i = 0; i < ws281xLedStrip.getLedsCount(); i++) {
            System.out.println("setting led at pos:" + i);
            ws281xLedStrip.setPixel(i, c);
        }
        ws281xLedStrip.setBrightness(brightness);
        System.out.println("rendering!");
        ws281xLedStrip.render();
        pos++;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }
}
