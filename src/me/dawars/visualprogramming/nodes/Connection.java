package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;
import me.dawars.visualprogramming.nodes.view.ConnectionView;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by dawars on 11/14/16.
 */
public class Connection<T> implements Serializable {
    private final ConnectionView view;
    public OutputPin<T> outPin;
    public InputPin<T> inPin;

    public Connection(OutputPin out, InputPin in) {
        this.view = new ConnectionView(this);
        outPin = out;
        inPin = in;
    }

    /**
     * Render a connection from pin to pin
     * @param graphics
     */
    public void render(Graphics2D graphics) {
        view.render(graphics);
    }
}
