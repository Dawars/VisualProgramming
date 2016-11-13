package me.dawars.visualprogramming.nodes.pin;

/**
 * Created by dawars on 11/8/16.
 */

/**
 * API to ACCESS data
 */
public class InPinModel<T> {
    private T defaultValue;

    public T getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(T defaultValue) {
        this.defaultValue = defaultValue;
    }


}
