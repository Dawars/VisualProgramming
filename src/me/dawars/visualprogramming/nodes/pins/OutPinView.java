package me.dawars.visualprogramming.nodes.pins;

import java.awt.*;

/**
 * Created by dawars on 11/27/16.
 */
public class OutPinView {

    private static final int PIN_WIDTH = 50;
    private static final int PIN_HEIGHT = 15;

    OutputPin<Double> pin;

    private Color color = Color.BLUE;
    private Color colorText = Color.WHITE;

    public OutPinView(OutputPin pin) {
        this.pin = pin;
    }

    //BB box
    public void render(Graphics2D g, int x, int y) {
        g.setColor(color);
        g.fillRect(x, y, PIN_WIDTH, PIN_HEIGHT);

        g.setColor(colorText);
        g.drawString(pin.getName(), x, y + PIN_HEIGHT /2);
    }
}
