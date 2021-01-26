package de.ianfd.led.ledappspring.model;
/*
 * Created by ian on 26.01.21
 * Location: de.ianfd.led.ledappspring.model
 * Created for the project ledapp-spring with the name StaticEffectModel
 */

public class StaticColorModel {

    private int r = 0;
    private int g = 0;
    private int b = 0;
    private int brightness = 0;

    public StaticColorModel() {
    }

    public StaticColorModel(int r, int g, int b, int brightness) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.brightness = brightness;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }
}
