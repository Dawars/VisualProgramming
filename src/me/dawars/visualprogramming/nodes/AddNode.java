package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.INode;

/**
 * Created by dawars on 26/09/16.
 */
public class AddNode implements INode {
    InputPin<Integer> a = new InputPin<>();
    InputPin<Integer> b = new InputPin<>();
    OutputPin<Integer> c = new OutputPin<>();

    @Override
    public void execute() {
        c.set(a.get() + b.get());
    }
}
