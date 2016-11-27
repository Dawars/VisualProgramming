package me.dawars.visualprogramming.nodes.view;

import me.dawars.visualprogramming.nodes.NodePresenter;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by dawars on 11/24/16.
 */
public class NodeView implements Serializable{

    private static final int WIDTH = 100;
    private static final int HEIGHT = 100; // not fixed
    NodePresenter presenter;

    public NodeView(NodePresenter presenter) {
        this.presenter = presenter;
    }

    private int x, y;

    public void render(Graphics2D g) {
        g.drawRect(x, y, WIDTH, HEIGHT);
        g.drawString(presenter.getName(), x + 10, y + 10);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
