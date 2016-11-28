package me.dawars.visualprogramming.nodes.pins;

import me.dawars.visualprogramming.nodes.Connection;
import me.dawars.visualprogramming.nodes.NodePresenter;
import me.dawars.visualprogramming.nodes.view.NodeView;

/**
 * Created by dawars on 26/09/16.
 */
public class InputPin<T> implements IPin {

    private final NodePresenter node;
    public Connection<T> connection;
    private final String name;

    private T defaultValue;
    private int x;
    private int y;

    public InputPin(NodePresenter node, String name) {
        this.node = node;
        this.name = name;
    }

    /**
     * Get name of the pin
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set default data
     *
     * @param data data to setDefaultValue
     */
    public void setDefaultValue(T data) {
        this.defaultValue = data;
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    /**
     * Get value of pin after execution
     * @return
     */
    public T getValue() {
        return connection == null ? defaultValue : connection.outPin.getValue();
    }

    /**
     * Get x coord of pin within node
     * @return
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Get y coord of pin within node
     * @return
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * Set position of pin within node
     * @param x
     * @param y
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Handle clicks on this pin
     */
    @Override
    public void clicked() {
        System.out.println(getName() + " pin clicked");
    }

    /**
     * If this is an input pin
     * @return
     */
    @Override
    public boolean isInput() {
        return true;
    }

    /**
     * Calculate position of pin
     * @param i
     */
    public void calcPosition(int i) {
        setPosition(x + NodeView.PADDING, y + (NodeView.PIN_HEIGHT + NodeView.PADDING) * (i + 1) + NodeView.HEADER);
    }

    /**
     * Get node containing pin
     * @return
     */
    public NodePresenter getNode() {
        return node;
    }
}
