package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 11/14/16.
 */
public class LerpNode extends NodePresenter  {
    private InputPin<Double> inA = new InputPin<>(this, "a");
    private InputPin<Double> inB = new InputPin<>(this, "b");
    private InputPin<Double> inT = new InputPin<>(this, "t");
    private OutputPin<Double> out = new OutputPin<>(this, "out");

    public LerpNode(){
        addInPin(inA);
        addInPin(inB);
        addInPin(inT);
        addOutPin(out);
    }
    @Override
    public void execute() {
        System.out.println("[LerpNode]");
        out.setValue((1 - inT.getValue()) * inA.getValue() + inT.getValue() * inB.getValue());
    }


    @Override
    public String getName() {
        return "Lerp Node";
    }

    public InputPin<Double> getInA() {
        return inA;
    }

    public InputPin<Double> getInB() {
        return inB;
    }

    public InputPin<Double> getInT() {
        return inT;
    }

    public OutputPin<Double> getOut() {
        return out;
    }
}
