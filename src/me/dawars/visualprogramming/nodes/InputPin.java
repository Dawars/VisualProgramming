package me.dawars.visualprogramming.nodes;

/**
 * Created by dawars on 26/09/16.
 */
public class InputPin<T /*extends DataTypes*/>  implements IPin{

    private DataTypes type;
    private T value;

    private OutputPin<Number> outPin;

    /**
     * Connect this
     *
     * @param pin
     * @return true if successfully connected, false otherwise
     */
    public boolean connectTo(OutputPin<Number> pin) {
        if (type.equals(pin.type)) {
            outPin = pin;
            return true;
        } else {
            return false;
        }
    }

    public T get() {
        return value;
    }
}
