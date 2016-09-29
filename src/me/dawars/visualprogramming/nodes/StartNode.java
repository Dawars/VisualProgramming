package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.INode;
import me.dawars.visualprogramming.nodes.pins.OutExecutionPin;

/**
 * Created by dawars on 26/09/16.
 */
public class StartNode implements INode {

    public OutExecutionPin outExecutionPin = new OutExecutionPin();

    @Override
    public void execute() {
        System.out.println("Start node");
    }

    @Override
    public INode getNextNode() {
        return outExecutionPin.getConnectedNode();
    }
}
