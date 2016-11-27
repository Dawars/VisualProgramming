package me.dawars.visualprogramming.nodes.pins;

import java.awt.*;

/**
 * Created by dawars on 11/27/16.
 */
public class InPinView {

    public static final int PIN_WIDTH = 50;
    public static final int PIN_HEIGHT = 15;

    InputPin<Double> pin;

    private Color color = Color.BLUE;
    private Color colorText = Color.WHITE;

    public InPinView(InputPin pin) {
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
