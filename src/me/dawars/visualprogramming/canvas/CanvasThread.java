package me.dawars.visualprogramming.canvas;

import me.dawars.visualprogramming.nodes.INode;
import me.dawars.visualprogramming.nodes.NodePresenter;

import javax.swing.*;
import java.io.Serializable;
import java.util.Deque;

/**
 * Created by dawars on 11/28/16.
 */
public class CanvasThread extends SwingWorker<Void, Void> implements Serializable {
    private final Deque<NodePresenter> nodes;
    public volatile boolean isRunning = false;

    public CanvasThread(Deque<NodePresenter> topoSort) {
        this.nodes = topoSort;
    }

    @Override
    protected Void doInBackground() throws Exception {
        System.out.println("thread started");
        while (isRunning) {

            for (INode node : nodes) {
                node.execute();
            }

            // TODO: update color panel in the loop every time
//            System.out.println("The result: " + start.getInput().getValue());

            Thread.sleep(1000 / 60);
        }

        return null;
    }
}
