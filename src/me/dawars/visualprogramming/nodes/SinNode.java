package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 11/14/16.
 */
public class SinNode extends NodePresenter  {

    private InputPin<Double> in = new InputPin<>(this, "in");
    private OutputPin<Double> out = new OutputPin<>(this, "out");

    /**
     * Calculates the sin of a
     */
    public SinNode(){
        addInPin(in);
        addOutPin(out);
    }

    @Override
    public void execute() {
        double sin = Math.sin(in.getValue());
        out.setValue(sin);
    }

    @Override
    public String getName() {
        return "Sin Node";
    }

    public InputPin<Double> getIn() {
        return in;
    }

    public OutputPin<Double> getOut() {
        return out;
    }
}
