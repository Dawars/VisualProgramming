package me.dawars.visualprogramming.canvas;

import me.dawars.visualprogramming.nodes.Connection;
import me.dawars.visualprogramming.nodes.NodePresenter;
import me.dawars.visualprogramming.nodes.pins.IPin;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dawars on 11/24/16.
 */
public class CanvasView extends JComponent {

    private final CanvasPresenter presenter;

    public CanvasView(CanvasPresenter presenter) {
        this.presenter = presenter;
        setPreferredSize(new Dimension(500, 500));
        setMinimumSize(new Dimension(300, 300));

        addMouseListener(presenter);
        addMouseMotionListener(presenter);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        for (NodePresenter node : presenter.getNodes()) {
            node.render((Graphics2D) graphics);
        }

        graphics.setColor(Color.BLACK);

        for (Connection connection : presenter.getConnections()) {
            connection.render((Graphics2D) graphics);
        }

        if (presenter.getMouseState() == CanvasPresenter.MouseState.CONNECTING) {
            Point mouse = presenter.getMousePt();
            IPin pin = presenter.getSelectedPin();
            graphics.drawLine(mouse.x, mouse.y, pin.getX(), pin.getY());
        }
    }

}
