package me.dawars.visualprogramming.nodes.pins;

import me.dawars.visualprogramming.nodes.ExecutableNode;

/**
 * Created by dawars on 27/09/16.
 */
public class OutExecutionPin implements IPin {

    private ExecutableNode connectedNode;

    public void connectTo(ExecutableNode node) {
        connectedNode = node;
    }

    public ExecutableNode getConnectedNode() {
        return connectedNode;
    }
}
