package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 11/14/16.
 */
public class MultiplyNode extends NodePresenter {
    private InputPin<Double> inA = new InputPin<>(this, "a");
    private InputPin<Double> inB = new InputPin<>(this, "b");
    private OutputPin<Double> out = new OutputPin<>(this, "out");

    public MultiplyNode(){
        addInPin(inA);
        addInPin(inB);
        addOutPin(out);
    }

    @Override
    public void execute() {
        out.setValue(inA.getValue() * inB.getValue());
    }


    @Override
    public String getName() {
        return "Multiply Node";
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
