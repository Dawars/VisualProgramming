package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.OutputPin;

import java.util.ArrayList;

/**
 * Created by dawars on 11/14/16.
 */
public class TimeNode extends NodePresenter {

    private OutputPin<Double> out = new OutputPin<>(this, "time");

    public TimeNode() {
        addOutPin(out);
    }

    @Override
    public void execute() {
        System.out.print("[TimeNode]");
        out.setValue((double) System.currentTimeMillis());
        System.out.println(out.getValue());
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
