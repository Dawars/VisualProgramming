package me.dawars.visualprogramming.nodes;

/**
 * Created by dawars on 26/09/16.
 */
public class OutputPin<T> implements IPin{
    public DataTypes type;
    private T value;

    /**
     * Sets the value of this OutputPin
     * @param value value to set for this pin
     */
    public void set(T value) {
        this.value = value;
    }
}
