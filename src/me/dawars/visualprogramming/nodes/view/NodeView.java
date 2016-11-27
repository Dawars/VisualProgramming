package me.dawars.visualprogramming.nodes.view;

import me.dawars.visualprogramming.nodes.NodePresenter;
import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by dawars on 11/24/16.
 */
public class NodeView implements Serializable {

    public static final int WIDTH = 100;
    public static final int HEADER = 5;
    private static int HEIGHT;
    public static final int PADDING = 5;
    public static final int PIN_HEIGHT = 15;
    public static final int PIN_WIDTH = 30;

    private NodePresenter node;
    private Color bgColor = new Color(75, 75, 75);
    private Color textColor = Color.white;

    public NodeView(NodePresenter node) {
        this.node = node;

        int height = Math.max(node.getInPins().size(), node.getOutPins().size());
        HEIGHT = (height + PADDING) * PIN_HEIGHT;

    }

    private int x, y;

    public void render(Graphics2D g) {
        g.setColor(bgColor);
        g.fillRect(x, y, WIDTH, HEIGHT);
        if (node.isSelected()) {
            g.setColor(Color.BLACK);
            g.drawRect(x, y, WIDTH, HEIGHT);
        }
        g.setColor(textColor);
        g.drawString(node.getName(), x + 10, y + 10);

        for (int i = 0; i < node.getInPins().size(); i++) {
            renderInPin(g, i);
        }

        for (int i = 0; i < node.getOutPins().size(); i++) {
            renderOutPin(g, i);
        }
    }

    /**
     * Draws a pin inside a node
     *
     * @param g
     * @param i the squence number of the pin in the node
     */
    private void renderInPin(Graphics2D g, int i) {
        InputPin pin = node.getInPins().get(i);
        Rectangle bb = getInPinBB(i);

        g.setColor(Color.BLUE);
        g.fillRect(bb.x, bb.y, bb.width, bb.height);

        g.setColor(textColor);
        g.drawString(pin.getName(), bb.x, bb.y + g.getFontMetrics().getHeight() / 2);
    }

    /**
     * Draws an OutPin inside a node
     *
     * @param g
     * @param i the squence number of the pin in the node
     */
    private void renderOutPin(Graphics2D g, int i) {
        OutputPin pin = node.getOutPins().get(i);
        Rectangle bb = getOutPinBB(i);

        g.setColor(Color.BLUE);
        g.fillRect(bb.x, bb.y, bb.width, bb.height);

        g.setColor(textColor);
        g.drawString(pin.getName(), bb.x, bb.y + g.getFontMetrics().getHeight() / 2);
    }

    public Rectangle getInPinBB(int i) {
        return new Rectangle(x + PADDING, y + (PIN_HEIGHT + PADDING) * (i + 1) + HEADER, PIN_WIDTH, PIN_HEIGHT);
    }

    public Rectangle getOutPinBB(int i) {
        return new Rectangle(x + WIDTH - PADDING - PIN_WIDTH, y + (PIN_HEIGHT + PADDING) * (i + 1) + HEADER, PIN_WIDTH, PIN_HEIGHT);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle getBoundingBox() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

}
