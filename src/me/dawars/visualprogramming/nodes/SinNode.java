package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 11/14/16.
 */
public class SinNode implements INode {

    public InputPin<Double> in = new InputPin<>(this);
    public OutputPin<Double> out = new OutputPin<>(this);

    @Override
    public void execute() {
        System.out.println("[SinNode]");
        out.setValue(Math.sin(in.getValue()));
    }
}
