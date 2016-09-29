package me.dawars.visualprogramming.nodes.pins;

import me.dawars.visualprogramming.nodes.DataTypes;

/**
 * Created by dawars on 26/09/16.
 */
public class OutputPin<T> implements IPin{
    public DataTypes type;
    private T value;

    /**
     * Sets the value of this OutputPin
     * @param value value to setValue for this pin
     */
    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
