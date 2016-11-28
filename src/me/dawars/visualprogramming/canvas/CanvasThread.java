package me.dawars.visualprogramming.canvas;

import me.dawars.visualprogramming.ColorPresenter;
import me.dawars.visualprogramming.nodes.INode;
import me.dawars.visualprogramming.nodes.NodePresenter;

import javax.swing.*;
import java.io.Serializable;
import java.util.Deque;
import java.util.List;

/**
 * Created by dawars on 11/28/16.
 */
public class CanvasThread extends SwingWorker<Void, Void> implements Serializable {
    private final Deque<NodePresenter> nodes;
    private final ColorPresenter colorPresenter;
    public volatile boolean isRunning = false;

    public CanvasThread(Deque<NodePresenter> topoSort, ColorPresenter colorPresenter) {
        this.nodes = topoSort;
        this.colorPresenter = colorPresenter;
    }

    @Override
    protected Void doInBackground() throws Exception {
        System.out.println("thread started");
        while (isRunning) {

            for (INode node : nodes) {
                node.execute();
            }
            publish();
            Thread.sleep(1000 / 60);
        }

        return null;
    }

    @Override
    protected void process(List<Void> list) {
        super.process(list);
        colorPresenter.repaint();

    }
}
