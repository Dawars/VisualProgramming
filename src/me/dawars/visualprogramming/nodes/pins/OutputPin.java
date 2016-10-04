package me.dawars.visualprogramming.nodes.pins;

import me.dawars.visualprogramming.nodes.DataNode;

/**
 * Created by dawars on 26/09/16.
 */
public class OutputPin<T> implements IPin {
    private T value;
    private DataNode node;

    public OutputPin(DataNode node) {
        this.node = node;
    }

    /**
     * Runs evaluate on DataNode and returns value
     *
     * @param value value to setValue for this pin
     */
    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        node.evaluate();
        return value;
    }
}
