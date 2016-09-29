package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.INode;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 26/09/16.
 */
public class ConstantNode<T> implements INode {

    public OutputPin<T> out = new OutputPin<>();

    public ConstantNode(T val) {
        out.setValue(val);
    }
}
