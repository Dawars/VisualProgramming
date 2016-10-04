package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.INode;

/**
 * Created by dawars on 10/4/16.
 */
public abstract class ExecutableNode implements INode {

    /**
     * Read inputs, execute the nodes logic and write the results to the output nodes
     */
    abstract public void execute();

    abstract public ExecutableNode getNextNode();
}
