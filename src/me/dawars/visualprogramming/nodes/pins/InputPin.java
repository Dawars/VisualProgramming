package me.dawars.visualprogramming.nodes.pins;

/**
 * Created by dawars on 26/09/16.
 */
public class InputPin<T /*extends DataTypes*/> implements IPin {

    //    private DataTypes type = T;
    private OutputPin<T> outPin;

    // used when no OutputNode is connected to this node
    private T value;

    /**
     * Connect this
     *
     * @param pin
     * @return true if successfully connected, false otherwise
     */
    public boolean connectTo(OutputPin<T> pin) {
        outPin = pin;
        return true;

        /*if (type.equals(pin.type)) {  // TODO: where to check? "Controller"
            outExecutionPin = pin;
            return true;
        } else {
            return false;
        }*/
    }

    /**
     * Set default data
     *
     * @param data data to setValue
     */
    public void setValue(T data) {
        this.value = data;
    }

    public T getValue() {
        // behaves weird
        return outPin == null ? value : outPin.getValue();
    }
}
