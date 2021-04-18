package de.ianfd.led.ledappspring.effects;
/*
 * Created by ian on 26.01.21
 * Location: de.ianfd.led.effects.effects
 * Created for the project EffectLibRpiWs281X with the name SolidColor
 */

import com.github.mbelling.ws281x.Color;
import com.github.mbelling.ws281x.Ws281xLedStrip;

public class SolidColorEffect extends BasicEffect {

    private int brightness = 25; // brightness ranges from 0-255 where 0 is black and 255 is blinding bright
    private int red = 10;
    private int green = 10;
    private int blue = 10;

    public SolidColorEffect(String name, int delay) {
        super(name, delay);
    }

    @Override
    public void firstFrame(Ws281xLedStrip ws281xLedStrip) {
        Color c = new Color(red, green, blue);
        ws281xLedStrip.setStrip(c);
        ws281xLedStrip.setBrightness(brightness);
        ws281xLedStrip.render();
    }


    @Override
    public void runFrame(Ws281xLedStrip ws281xLedStrip) {
        // do nothing here if you just want one state!
    }

    // set the color that is going to be displayed - essential for this effect
    public void setColor(int r, int g, int b, int brightness) {
        this.red = r * (brightness / 255);
        this.green = g * (brightness / 255);
        this.blue = b * (brightness / 255);
        this.brightness = brightness;
    }

}
