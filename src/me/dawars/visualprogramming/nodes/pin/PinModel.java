package me.dawars.visualprogramming.nodes.pin;

import me.dawars.visualprogramming.types.DataType;

/**
 * Created by dawars on 11/8/16.
 */

/**
 * API to ACCESS data
 */
public class PinModel {
    private Object defaultValue;
    private Object value;
    private DataType type;

    public Object getDefaultValue() {
        return defaultValue;
    }

    public Object getValue() {
        return value;
    }

    public DataType getType() {
        return type;
    }
}
