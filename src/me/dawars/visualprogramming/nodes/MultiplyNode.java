package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 11/14/16.
 */
public class MultiplyNode extends NodePresenter {
    public InputPin<Double> inA = new InputPin<>(this);
    public InputPin<Double> inB = new InputPin<>(this);
    public OutputPin<Double> out = new OutputPin<>(this);

    @Override
    public void execute() {
        System.out.print("[MultiplyNode]");
        out.setValue(inA.getValue() * inB.getValue());

        System.out.println(out.getValue());
    }


    @Override
    public String getName() {
        return "Multiply Node";
    }
}
