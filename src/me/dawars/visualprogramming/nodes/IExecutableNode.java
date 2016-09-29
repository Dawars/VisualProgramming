package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.INode;

/**
 * Created by dawars on 29/09/16.
 */
public interface IExecutableNode extends INode {

    /**
     * Reads values from InputPins, executes node logic and puts results to OutputPins
     */
    void execute();

    /**
     * Choose the next node to execute (useful when there are multiple output Execution Pins)
     * @return the next Node to execute
     */
    IExecutableNode getNextNode();
}
