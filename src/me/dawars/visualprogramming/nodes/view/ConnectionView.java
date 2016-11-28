package me.dawars.visualprogramming.nodes.view;

import me.dawars.visualprogramming.nodes.Connection;
import me.dawars.visualprogramming.nodes.NodePresenter;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by dawars on 11/27/16.
 */
public class ConnectionView implements Serializable {
    private final Connection conn;

    public ConnectionView(Connection conn) {
        this.conn = conn;
    }

    public void render(Graphics2D g) {
        NodePresenter node1 = conn.outPin.getNode();
        Rectangle bb1 = node1.getBoundingBox();
        int x1 = conn.outPin.getX();
        int y1 = conn.outPin.getY();

        NodePresenter node2 = conn.inPin.getNode();
        Rectangle bb2 = node2.getBoundingBox();
        int x2 = conn.inPin.getX();
        int y2 = conn.inPin.getY();
        g.drawLine(bb1.x + x1, bb1.y + y1, bb2.x + x2, bb2.y + y2);
    }
}
