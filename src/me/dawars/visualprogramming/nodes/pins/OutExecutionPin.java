package me.dawars.visualprogramming.nodes.pins;

import me.dawars.visualprogramming.INode;

/**
 * Created by dawars on 27/09/16.
 */
public class OutExecutionPin implements IPin {

    private INode connectedNode;

    public void connectTo(INode node) {
        connectedNode = node;
    }

    public INode getConnectedNode() {
        return connectedNode;
    }
}
