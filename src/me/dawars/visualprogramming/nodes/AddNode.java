package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 26/09/16.
 */
public class AddNode extends NodePresenter {
    private InputPin<Double> inA = new InputPin<>(this, "a");
    private InputPin<Double> inB = new InputPin<>(this, "b");
    private OutputPin<Double> out = new OutputPin<>(this, "c");

    public AddNode() {
        addInPin(inA);
        addInPin(inB);
        addOutPin(out);
    }

    @Override
    public void execute() {
        System.out.println("[AddNode]");
        out.setValue(inA.getValue() + inB.getValue());
    }

    @Override
    public String getName() {
        return "Add Node";
    }

    public InputPin<Double> getInA() {
        return inA;
    }

    public InputPin<Double> getInB() {
        return inB;
    }

    public OutputPin<Double> getOut() {
        return out;
    }
}
