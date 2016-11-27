package me.dawars.visualprogramming.nodes.pins;

import me.dawars.visualprogramming.nodes.Connection;
import me.dawars.visualprogramming.nodes.INode;
import me.dawars.visualprogramming.nodes.NodePresenter;
import me.dawars.visualprogramming.nodes.view.NodeView;

import java.awt.*;

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

    public T getValue() {

        return connection == null ? defaultValue : connection.outPin.getValue();
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void clicked() {
        System.out.println(getName() + " pin clicked");
    }

    @Override
    public boolean isInput() {
        return true;
    }

    public void calcPosition(int i) {
        setPosition(x + NodeView.PADDING, y + (NodeView.PIN_HEIGHT + NodeView.PADDING) * (i + 1) + NodeView.HEADER);
    }

    public NodePresenter getNode() {
        return node;
    }
}
