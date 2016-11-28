package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;

/**
 * Created by dawars on 26/09/16.
 */
public class StartNode extends NodePresenter {

    private InputPin<Double> inR = new InputPin<>(this, "Red");
    private InputPin<Double> inG = new InputPin<>(this, "Green");
    private InputPin<Double> inB = new InputPin<>(this, "Blue");

    public StartNode() {
        addInPin(inR);
        addInPin(inG);
        addInPin(inB);
    }

    @Override
    public void execute() {
        System.out.print("[StartNode]");
        System.out.println("RED: " +inR.getValue());

//        System.out.println(inG.getValue());
//        System.out.println(inB.getValue());
    }


    @Override
    public String getName() {
        return "Start Node";
    }

    public InputPin getInputR() {
        return inR;
    }

    public InputPin getInputG() {
        return inG;
    }

    public InputPin getInputB() {
        return inB;
    }
}
