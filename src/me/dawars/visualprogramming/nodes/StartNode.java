package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;

/**
 * Created by dawars on 26/09/16.
 */
public class StartNode extends NodePresenter {

    private InputPin<Double> in = new InputPin<>(this);

    @Override
    public void execute() {
        System.out.print("[StartNode]");
        System.out.println(in.getValue());
    }


    @Override
    public String getName() {
        return "Start Node";
    }

    public InputPin getInput() {
        return in;
    }
}
