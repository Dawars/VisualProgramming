package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 11/14/16.
 */
public class CosNode extends NodePresenter {

    public InputPin<Double> in = new InputPin<>(this);
    public OutputPin<Double> out = new OutputPin<>(this);

    @Override
    public void execute() {
        System.out.print("[CosNode]");
        out.setValue(Math.cos(in.getValue()));
        System.out.println(out.getValue());
    }

    @Override
    public String getName() {
        return "Cos Node";
    }
}
