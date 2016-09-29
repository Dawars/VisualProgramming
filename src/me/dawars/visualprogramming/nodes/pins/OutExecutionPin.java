package me.dawars.visualprogramming.nodes.pins;

import me.dawars.visualprogramming.nodes.IExecutableNode;

/**
 * Created by dawars on 27/09/16.
 */
public class OutExecutionPin implements IPin {

    private IExecutableNode connectedNode;

    public void connectTo(IExecutableNode node) {
        connectedNode = node;
    }

    public IExecutableNode getConnectedNode() {
        return connectedNode;
    }
}
