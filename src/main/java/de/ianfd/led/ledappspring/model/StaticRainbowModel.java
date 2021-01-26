package de.ianfd.led.ledappspring.model;
/*
 * Created by ian on 26.01.21
 * Location: de.ianfd.led.ledappspring.model
 * Created for the project ledapp-spring with the name StaticRainbowModel
 */

public class StaticRainbowModel {

    private int speed = 0;
    private int brightness = 0;

    public StaticRainbowModel(int speed, int brightness) {
        this.speed = speed;
        this.brightness = brightness;
    }

    public StaticRainbowModel() {
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }
}
