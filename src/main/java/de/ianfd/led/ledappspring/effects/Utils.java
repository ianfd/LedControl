package de.ianfd.led.ledappspring.effects;
/*
 * Created by ian on 26.01.21
 * Location: de.ianfd.led.ledappspring.effects
 * Created for the project ledapp-spring with the name utils
 */


import com.github.mbelling.ws281x.Color;

public class Utils {

    // Calculates colors for different positions (0-255)
    public Color colorWheel(int pos) {
        if (pos < 85) {
            return new Color(pos * 3, 255 - pos * 3, 0);
        } else if (pos < 170) {
            pos = pos - 85;
            return new Color(255 - pos * 3, 0, pos * 3);
        } else if (pos <= 254) {
            pos = pos - 170;
            return new Color(0, pos * 3, 255 - pos * 3);
        } else {
            return new Color(255, 0, 0);
        }
    }

}
