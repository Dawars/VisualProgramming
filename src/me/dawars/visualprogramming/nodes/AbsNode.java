package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 11/14/16.
 */
public class AbsNode extends NodePresenter {

    private InputPin<Double> in = new InputPin<>(this, "in");
    private OutputPin<Double> out = new OutputPin<>(this, "out");

    /**
     * Abs value of input
     */
    public AbsNode() {
        addInPin(in);
        addOutPin(out);
    }

    @Override
    public void execute() {
        out.setValue(Math.abs(in.getValue()));
    }

    @Override
    public String getName() {
        return "Abs Node";
    }

    public InputPin<Double> getIn() {
        return in;
    }

    public OutputPin<Double> getOut() {
        return out;
    }
}
