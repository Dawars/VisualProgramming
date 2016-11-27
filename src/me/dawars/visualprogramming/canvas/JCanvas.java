package me.dawars.visualprogramming.canvas;

import me.dawars.visualprogramming.nodes.NodePresenter;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dawars on 11/24/16.
 */
public class JCanvas extends JComponent{

    private final CanvasPresenter presenter;

    public JCanvas(CanvasPresenter presenter) {
        this.presenter = presenter;
        setPreferredSize(new Dimension(500, 500));
        setMinimumSize(new Dimension(300, 300));

        addMouseListener(presenter);
        addMouseMotionListener(presenter);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        System.out.println("painting JCanvas");

        for (NodePresenter node : presenter.getNodes()) {
            if (graphics instanceof Graphics2D)
                node.render((Graphics2D) graphics);
        }
    }

}
