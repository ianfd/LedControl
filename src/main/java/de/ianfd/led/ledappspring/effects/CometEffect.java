package de.ianfd.led.ledappspring.effects;
/*
 * Created by ian on 18.04.21
 * Location: de.ianfd.led.ledappspring.effects
 * Created for the project ledapp-spring with the name CometEffect
 */

import com.github.mbelling.ws281x.Color;
import com.github.mbelling.ws281x.Ws281xLedStrip;

public class CometEffect extends BasicEffect {

    private int headPosition = 0;
    private int tailLength = 0;
    private Color headColor;
    private int maxBrightness = 0; // range from 1 - 255, defines the brightness of the comets head


    public CometEffect(String name, int delay) {
        super(name, delay);
    }

    @Override
    public void firstFrame(Ws281xLedStrip ws281xLedStrip) {
        // no nothing in here
    }

    @Override
    public void runFrame(Ws281xLedStrip strip) {
        // actual comet run
        if (headPosition < (strip.getLedsCount() + tailLength)) {
            if (headPosition < strip.getLedsCount()) {
                strip.setPixel(headPosition, new Color(headColor.getRed() * (maxBrightness / 255), headColor.getGreen() * (maxBrightness / 255), headColor.getBlue() * (maxBrightness / 255)));
            }
            drawTail(headPosition, strip);
        } else {
            // join this, when LED count is too big
            headPosition = 0;
        }
        strip.render();
    }

    public void drawTail(int startPos, Ws281xLedStrip strip) {
        // start position = position of head
        if (tailLength > 0 && startPos > 0) {
            // steps
            // calculate decrease by step
            for (int i = 0; i < tailLength; i++) {
                // so 1- headpos to get one position
                int newPos = (i + 1) - startPos;
                // calc new brightness ratio
                int brightness = (maxBrightness / (255 * (i + 1)));
                // check if new pos is in defined radius
                if ((newPos > 0) && (newPos < strip.getLedsCount())) {
                    // check if the pixel is on the LED strip
                    strip.setPixel((i + 1), new Color(headColor.getRed() * brightness, headColor.getGreen() * brightness, headColor.getBlue() * brightness));
                }
            }
        }
    }

    public void setHeadColor(int r, int g, int b) {
        this.headColor = new Color(r, g, b);
    }

    public void setHeadPosition(int headPosition) {
        this.headPosition = headPosition;
    }

    public void setTailLength(int tailLength) {
        this.tailLength = tailLength;
    }

    public void setMaxBrightness(int maxBrightness) {
        this.maxBrightness = maxBrightness;
    }
}
