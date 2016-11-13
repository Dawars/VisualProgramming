package me.dawars.visualprogramming.nodes.pin;

/**
 * Created by dawars on 11/8/16.
 */

/**
 * gives data to VIEW from MODEL
 */
public class InPin<T> {

    private InPinModel<T> model = new InPinModel<>();
    OutPin<T> connectedPin = null;


    public void onClicked() {

    }

    public void setConnectedPin(OutPin<T> connectedPin) {
        this.connectedPin = connectedPin;
    }

    public OutPin<T> getConnectedPin() {
        return connectedPin;
    }

    public void setDefaultValue(T defaultValue) {
        model.setDefaultValue(defaultValue);
    }

    public T getDefaultValue() {
        return model.getDefaultValue();
    }

    public T getValue() {
        return connectedPin != null ? connectedPin.getValue() : getDefaultValue();
    }
}
