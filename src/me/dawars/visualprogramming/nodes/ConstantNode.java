package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 26/09/16.
 */
public class ConstantNode<T> extends DataNode {

    public OutputPin<T> out = new OutputPin<>(this);

    /**
     * Set the default value - only for testing
     * @param val
     */
    public ConstantNode(T val) {
        out.setValue(val);
    }

    @Override
    public void evaluate() {
        System.out.println("[ConstNode eval]");

    }
}
