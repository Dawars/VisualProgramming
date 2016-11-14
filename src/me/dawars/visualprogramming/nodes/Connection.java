package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 11/14/16.
 */
public class Connection<T> {
    public OutputPin<T> outPin;
    public InputPin<T> inPin;

    public Connection(OutputPin out, InputPin in) {
        outPin = out;
        inPin = in;
    }
}
