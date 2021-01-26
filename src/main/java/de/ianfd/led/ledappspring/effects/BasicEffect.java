package de.ianfd.led.ledappspring.effects;
/*
 * Created by ian on 26.01.21
 * Location: de.ianfd.led.effects
 * Created for the project EffectLibRpiWs281X with the name BasicEffect
 */

import com.github.mbelling.ws281x.Ws281xLedStrip;

public abstract class BasicEffect {

    private String name = "";
    private boolean firstRun = true;
    private int delay = 1000; // 100 = 1s delay | Simply: delay between each frame
    private long frameCounter = 0;

    public BasicEffect(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    public abstract void firstFrame(Ws281xLedStrip ws281xLedStrip); //special usage for the first frame!

    public void executeTask(Ws281xLedStrip ws281xLedStrip) {
        if (firstRun) {
            firstFrame(ws281xLedStrip);
            firstRun = false;
        }
        if (frameCounter >= delay) {
            runFrame(ws281xLedStrip);
            frameCounter = 0;
        } else {
            frameCounter++;
        }
    }

    public abstract void runFrame(Ws281xLedStrip ws281xLedStrip); // run with delay

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
