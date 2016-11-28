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

    /**
     * Gives color to be displayed
     * @return color
     */
    public Color getColor() {
        return node.getColor();
    }

    /**
     * Repaint {@link ColorView}
     */
    public void repaint() {
        view.repaint();
    }
}
