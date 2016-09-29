package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;

/**
 * Created by dawars on 27/09/16.
 */
public class PrintNode implements IExecutableNode{

    private String value;
    public InputPin<String> inString = new InputPin<>();

    public PrintNode(){}

    public PrintNode(String s) {
        super();
        value = s;
    }

    @Override
    public void execute() {
        System.out.println(inString.getValue());
    }

    @Override
    public IExecutableNode getNextNode() {
        return null;
    }
}
