package me.dawars.visualprogramming.nodes.pins;

import me.dawars.visualprogramming.nodes.Connection;
import me.dawars.visualprogramming.nodes.INode;

/**
 * Created by dawars on 26/09/16.
 */
public class InputPin<T> implements IPin {

    private final INode node;
    public Connection<T> connection;

    private T defaultValue;

    public InputPin(INode node) {
        this.node = node;
    }

    /**
     * Set default data
     *
     * @param data data to setDefaultValue
     */
    public void setDefaultValue(T data) {
        this.defaultValue = data;
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    public T getValue() {

        return connection == null ? defaultValue : connection.outPin.getValue();
    }
}
