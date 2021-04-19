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
    private Color backgroundColor;
    private Color headColor = new Color(255, 0, 0);
    private double maxBrightness = 0; // range from 1 - 255, defines the brightness of the comets head


    public CometEffect(String name, int delay) {
        super(name, delay);
    }

    @Override
    public void firstFrame(Ws281xLedStrip ws281xLedStrip) {
        // no nothing in here
    }

    @Override
    public void runFrame(Ws281xLedStrip strip) {
        // setting all pixels to black before start
        for (int i = 0; i < strip.getLedsCount(); i++) {
            strip.setPixel(i, backgroundColor);
        }
        // actual comet run
        System.out.println("drawing at position ");
        if (headPosition < (strip.getLedsCount() + tailLength)) {
            System.out.println("is smaller than this");
            if (headPosition < strip.getLedsCount()) {
                System.out.println("setting to r:" + headColor.getRed() + " / green: " + headColor.getGreen() + " / blue: " + headColor.getBlue());
                System.out.println("new setting to r:" + headColor.getRed() * (maxBrightness / 255) + " / green: " + headColor.getGreen() * (maxBrightness / 255) + " / blue: " + headColor.getBlue() * (maxBrightness / 255));
                strip.setPixel(headPosition, new Color(((int) (headColor.getRed() * (maxBrightness / 255))), ((int) (headColor.getGreen() * (maxBrightness / 255))), ((int) (headColor.getBlue() * (maxBrightness / 255)))));
            }
            System.out.println("drawing the tail");
            if (tailLength > 0 && headPosition > 0) {
                System.out.println("drawing the tail");
                // steps
                // calculate decrease by step
                for (int i = 0; i < tailLength; i++) {
                    System.out.println("drawing tail pos: " + i);
                    // so 1- headpos to get one position
                    int newPos = headPosition - (i + 1);
                    // calc new brightness ratio
                    double brightness = (maxBrightness / (255 * (i + 1)));
                    System.out.println("max brightness: " + maxBrightness + " / stepping: " + (255 * (i + 1)) + " / quo: " + brightness);
                    // check if new pos is in defined radius
                    System.out.println("trying to draw at: " + newPos);
                    if ((newPos >= 0) && (newPos < strip.getLedsCount())) {
                        System.out.println("drawing at pos: " + newPos);
                        // check if the pixel is on the LED strip
                        System.out.println("setting to r:" + headColor.getRed() + " / green: " + headColor.getGreen() + " / blue: " + headColor.getBlue());
                        System.out.println("new setting to r:" + headColor.getRed() * brightness + " / green: " + headColor.getGreen() * brightness + " / blue: " + headColor.getBlue() * brightness);
                        strip.setPixel(newPos, new Color(((int) (headColor.getRed() * brightness)),
                                ((int) (headColor.getGreen() * brightness)), ((int) (headColor.getBlue() * brightness))));
                    }
                }
            }
            strip.render();
            headPosition++;
        } else {
            // join this, when LED count is too big
            headPosition = 0;
        }

    }

    public void setHeadColor(int r, int g, int b) {
        this.headColor = new Color(r, g, b);
    }

    public void setHeadPosition(int headPosition) {
        this.headPosition = headPosition;
    }

    public void setBackgroundColor(int r, int g, int b, int bright) {
        double brightnessratio = ((double) bright / 255.0);
        this.backgroundColor = new Color((int) (r * brightnessratio), (int) (g * brightnessratio), (int) (b * brightnessratio));
    }

    public void setTailLength(int tailLength) {
        this.tailLength = tailLength;
    }

    public void setMaxBrightness(int maxBrightness) {
        this.maxBrightness = maxBrightness;
    }
}
