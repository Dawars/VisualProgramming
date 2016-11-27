package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 11/14/16.
 */
public class LerpNode extends NodePresenter  {
    public InputPin<Double> inA = new InputPin<>(this);
    public InputPin<Double> inB = new InputPin<>(this);
    public InputPin<Double> inT = new InputPin<>(this);
    public OutputPin<Double> outC = new OutputPin<>(this);

    @Override
    public void execute() {
        System.out.println("[LerpNode]");
        outC.setValue((1 - inT.getValue()) * inA.getValue() + inT.getValue() * inB.getValue());
    }


    @Override
    public String getName() {
        return "Lerp Node";
    }
}
