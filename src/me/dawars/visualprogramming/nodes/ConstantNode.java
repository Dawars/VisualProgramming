package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 26/09/16.
 */
public class ConstantNode extends NodePresenter {

    private OutputPin<Double> out = new OutputPin<>(this, "c");

    /**
     * A constant value
     */
    public ConstantNode(){
        addOutPin(out);
    }
    @Override
    public void execute() {
    }

    public void setValue(Double value) {
        out.setValue(value);
    }

    public OutputPin getOut() {
        return out;
    }

    @Override
    public String getName() {
        return "Constant Node";
    }
}
