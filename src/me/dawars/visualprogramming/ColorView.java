package me.dawars.visualprogramming;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * Created by dawars on 11/28/16.
 */
public class ColorView extends JPanel implements Serializable{

    private final ColorPresenter presenter;

    public ColorView(ColorPresenter presenter) {
        this.presenter = presenter;
        setMinimumSize(new Dimension(100, 100));
    }

    @Override
    public void paint(Graphics graphics) {
        Color color = presenter.getColor();
        if (color != null) {
            graphics.setColor(color);
        } else {
            graphics.setColor(Color.MAGENTA);
        }
        graphics.fillRect(0, 0, getWidth(), getHeight());
    }
}
