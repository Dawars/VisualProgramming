package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 11/14/16.
 */
public class CosNode extends NodePresenter {

    private InputPin<Double> in = new InputPin<>(this, "in");
    private OutputPin<Double> out = new OutputPin<>(this, "out");

    public CosNode(){
        addInPin(in);
        addOutPin(out);
    }

    @Override
    public void execute() {
        out.setValue(Math.cos(in.getValue()));
    }

    @Override
    public String getName() {
        return "Cos Node";
    }

    public InputPin<Double> getIn() {
        return in;
    }

    public OutputPin<Double> getOut() {
        return out;
    }
}
