package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 26/09/16.
 */
public class AddNode implements INode {
    public InputPin<Double> inA = new InputPin<>(this);
    public InputPin<Double> inB = new InputPin<>(this);
    public OutputPin<Double> outC = new OutputPin<>(this);

    @Override
    public void execute() {
        System.out.println("[AddNode]");
        outC.setValue(inA.getValue() + inB.getValue());
    }
}
