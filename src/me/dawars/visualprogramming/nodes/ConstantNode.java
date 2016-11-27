package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 26/09/16.
 */
public class ConstantNode extends NodePresenter  {

    private OutputPin<Double> out = new OutputPin<>(this);

    @Override
    public void execute() {
        System.out.print("[ConstNode]");
        System.out.println(out.getValue());
    }

    public void setValue(Double value) {
        out.setValue(value);
    }

    public OutputPin getOutput() {
        return out;
    }

    @Override
    public String getName() {
        return "Constant Node";
    }
}
