package me.dawars.visualprogramming.nodes.view;

import me.dawars.visualprogramming.nodes.NodePresenter;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by dawars on 11/24/16.
 */
public class NodeView implements Serializable {

    private static final int WIDTH = 100;
    private static final int PADDING = 5;
    private static final int PIN_HEIGHT = 15;
    private static final int PIN_WIDTH = 50;

    private NodePresenter presenter;
    private Color bgColor = new Color(75, 75, 75);
    private Color textColor = Color.white;

    public NodeView(NodePresenter presenter) {
        this.presenter = presenter;
    }

    private int x, y;

    public void render(Graphics2D g) {
        int height = Math.max(presenter.getInPins().size(), presenter.getOutPins().size());
        g.setColor(bgColor);
        g.fillRect(x, y, WIDTH, (height + PADDING) * PIN_HEIGHT);

        g.setColor(textColor);
        g.drawString(presenter.getName(), x + 10, y + 10);

        for (int i = 0; i < presenter.getInPins().size(); i++) {
            presenter.getInPins().get(i).getView().render(g, x + PADDING, y + 3 * PADDING + i * (PADDING + PIN_HEIGHT));
        }

        for (int i = 0; i < presenter.getOutPins().size(); i++) {
            presenter.getOutPins().get(i).getView().render(g, x + WIDTH - PADDING - PIN_WIDTH, y + 3 * PADDING + i * (PADDING + PIN_HEIGHT));
        }
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
