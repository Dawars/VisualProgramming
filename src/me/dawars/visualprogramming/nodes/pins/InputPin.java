package me.dawars.visualprogramming.nodes.pins;

import me.dawars.visualprogramming.nodes.DataTypes;

/**
 * Created by dawars on 26/09/16.
 */
public class InputPin<T /*extends DataTypes*/>  implements IPin{

    private DataTypes type;
    private OutputPin<T> outPin;

    // used when no OutputNode is connected to this node
    private T defaultData;

    /**
     * Connect this
     *
     * @param pin
     * @return true if successfully connected, false otherwise
     */
    public boolean connectTo(OutputPin<T> pin) {
        if (type.equals(pin.type)) {
            outPin = pin;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Set default data
     * @param data data to setValue
     */
    public void setDefaultData(T data){
        this.defaultData = data;
    }

    public T getValue() {
        return outPin == null ? defaultData : outPin.getValue();
    }
}
