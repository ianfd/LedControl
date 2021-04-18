package de.ianfd.led.ledappspring.model;
/*
 * Created by ian on 18.04.21
 * Location: de.ianfd.led.ledappspring.model
 * Created for the project ledapp-spring with the name CometModel
 */

public class CometModel {

    private int cometR = 0;
    private int cometG = 0;
    private int cometB = 0;
    private int brightness = 0;
    private int speed = 0;
    private int tailLength = 0;

    public CometModel(int cometR, int cometG, int cometB, int brightness, int speed, int tailLength) {
        this.cometR = cometR;
        this.cometG = cometG;
        this.cometB = cometB;
        this.brightness = brightness;
        this.speed = speed;
        this.tailLength = tailLength;
    }

    public CometModel() {
    }

    public int getCometR() {
        return cometR;
    }

    public void setCometR(int cometR) {
        this.cometR = cometR;
    }

    public int getCometG() {
        return cometG;
    }

    public void setCometG(int cometG) {
        this.cometG = cometG;
    }

    public int getCometB() {
        return cometB;
    }

    public void setCometB(int cometB) {
        this.cometB = cometB;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTailLength() {
        return tailLength;
    }

    public void setTailLength(int tailLength) {
        this.tailLength = tailLength;
    }
}
