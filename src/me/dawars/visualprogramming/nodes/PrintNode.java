package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.INode;
import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutExecutionPin;

/**
 * Created by dawars on 27/09/16.
 */
public class PrintNode<T> implements INode {

    private String value;
    public InputPin<T> inPin = new InputPin<>();
    public OutExecutionPin outExecutionPin = new OutExecutionPin();

    public PrintNode(){}

    public PrintNode(String s) {
        super();
        value = s;
    }

    @Override
    public void execute() {
        System.out.println(inPin.getValue().toString());
    }

    @Override
    public INode getNextNode() {
        return outExecutionPin.getConnectedNode();
    }
}
