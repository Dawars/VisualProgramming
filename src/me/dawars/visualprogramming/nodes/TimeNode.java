package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.OutputPin;

import java.util.ArrayList;

/**
 * Created by dawars on 11/14/16.
 */
public class TimeNode extends NodePresenter {

    private OutputPin<Double> out = new OutputPin<>(this, "time");

    /**
     * Gives the current time in millis /1000
     */
    public TimeNode() {
        addOutPin(out);
    }

    @Override
    public void execute() {
        out.setValue((double) System.currentTimeMillis()/ 1000.f);
    }

    @Override
    public String getName() {
        return "Time Node";
    }

    @Override
    public ArrayList<OutputPin> getOutPins() {
        return super.getOutPins();
    }
}
