package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.view.NodeView;

import java.awt.*;
import java.io.Serializable;


/**
 * Created by dawars on 11/24/16.
 */
public abstract class NodePresenter implements INode, Serializable {

    NodeView view;
    public NodePresenter() {
        view = new NodeView(this);
    }


    public void setPosition(int x, int y) {
        view.setPosition(x, y);
    }

    public abstract String getName();


    public void render(Graphics2D graphics) {
        view.render(graphics);
    }

}
