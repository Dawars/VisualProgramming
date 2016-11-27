package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;
import me.dawars.visualprogramming.nodes.view.ConnectionView;

import java.awt.*;

/**
 * Created by dawars on 11/14/16.
 */
public class Connection<T> {
    private final ConnectionView view;
    public OutputPin<T> outPin;
    public InputPin<T> inPin;

    public Connection(OutputPin out, InputPin in) {
        this.view = new ConnectionView(this);
        outPin = out;
        inPin = in;
    }

    public void render(Graphics2D graphics) {
        view.render(graphics);
    }
}
