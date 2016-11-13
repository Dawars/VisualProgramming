package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.View;

import java.awt.*;

/**
 * Created by dawars on 11/8/16.
 */
public class NodeView implements View {

    NodePresenter node;

    public static final int RADIUS = 20;

    private int posX, posY;
    private int sizeX, sizeY;

    public void setPos(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRoundRect(posX, posY, sizeX, sizeY, RADIUS, RADIUS);
    }
}
