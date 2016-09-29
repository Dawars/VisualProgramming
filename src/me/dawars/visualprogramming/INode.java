package me.dawars.visualprogramming;

/**
 * Created by dawars on 26/09/16.
 */
public interface INode {

    /**
     * Read inputs, execute the nodes logic and write the results to the output nodes
     */
    void execute();

    INode getNextNode();
}
