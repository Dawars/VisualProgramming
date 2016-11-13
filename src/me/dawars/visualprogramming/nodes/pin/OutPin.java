package me.dawars.visualprogramming.nodes.pin;

/**
 * Created by dawars on 11/8/16.
 */

/**
 * gives data to VIEW from MODEL
 */
public class OutPin<T> {

    private OutPinModel<T> model = new OutPinModel<>();

    public void onClicked() {

    }

    public T getValue() {
        return model.getValue();
    }

    public void setValue(T value) {
        model.setValue(value);
    }
}
