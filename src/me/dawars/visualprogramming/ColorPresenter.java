package me.dawars.visualprogramming;

import me.dawars.visualprogramming.nodes.RenderNode;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by dawars on 11/28/16.
 */
public class ColorPresenter implements Serializable {
    private final RenderNode node;
    ColorView view;

    public ColorPresenter(RenderNode node) {
        this.view = new ColorView(this);
        this.node = node;
    }

    public Color getColor() {
        return node.getColor();
    }

    public void repaint() {
        view.repaint();
    }
}
