package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 11/14/16.
 */
public class TimeNode extends NodePresenter {

    public OutputPin<Double> out = new OutputPin<>(this);

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
}
