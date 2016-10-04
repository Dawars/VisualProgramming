package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutExecutionPin;

/**
 * Created by dawars on 27/09/16.
 */
public class PrintNode<T> extends ExecutableNode {

    public InputPin<T> inPin = new InputPin<>();
    public OutExecutionPin outExecutionPin = new OutExecutionPin();

    public PrintNode() {
        this(null);
    }

    public PrintNode(T s) {
        super();
        inPin.setValue(s);
    }

    @Override
    public void execute() {

        System.out.println("[PrintNode execute]");
        System.out.println(inPin.getValue().toString());
    }

    @Override
    public ExecutableNode getNextNode() {
        return outExecutionPin.getConnectedNode();
    }
}
