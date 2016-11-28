package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 11/14/16.
 */
public class OneMinusNode extends NodePresenter {

    private InputPin<Double> in = new InputPin<>(this, "in");
    private OutputPin<Double> out = new OutputPin<>(this, "out");

    /**
     * Gives 1 - a
     */
    public OneMinusNode() {
        addInPin(in);
        addOutPin(out);
    }

    @Override
    public void execute() {
        out.setValue(1 - in.getValue());
    }

    @Override
    public String getName() {
        return "One Minus Node";
    }

    public InputPin<Double> getIn() {
        return in;
    }

    public OutputPin<Double> getOut() {
        return out;
    }
}
