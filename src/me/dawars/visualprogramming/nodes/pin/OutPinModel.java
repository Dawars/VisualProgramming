package me.dawars.visualprogramming.nodes.pin;

/**
 * Created by dawars on 11/8/16.
 */

/**
 * API to ACCESS data
 */
public class OutPinModel<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }


}
