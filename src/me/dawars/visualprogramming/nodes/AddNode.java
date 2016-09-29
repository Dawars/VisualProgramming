package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.INode;
import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 26/09/16.
 */
public class AddNode implements INode {
    public InputPin<Integer> a = new InputPin<>();
    public InputPin<Integer> b = new InputPin<>();
    public OutputPin<Integer> c = new OutputPin<>();

    @Override
    public void execute() {
        System.out.println("addition");
        c.setValue(a.getValue() + b.getValue());
    }

    @Override
    public INode getNextNode() {
        return null;
    }
}
