package me.dawars.visualprogramming;

import me.dawars.visualprogramming.nodes.ConstantNode;
import me.dawars.visualprogramming.nodes.IExecutableNode;
import me.dawars.visualprogramming.nodes.PrintNode;
import me.dawars.visualprogramming.nodes.StartNode;

/**
 * Created by dawars on 26/09/16.
 */
public class App {

    public static void main(String[] args) {
        System.out.println("---Dawars Visual Programming---");

        StartNode start = new StartNode();
        PrintNode print = new PrintNode("Default text");
        ConstantNode constant = new ConstantNode("Hello Node!");

        print.inString.connectTo(constant.out);
        start.outPin.connectTo(print);

        IExecutableNode nextNode = start;
        while(nextNode != null){
            nextNode.execute();
            nextNode = nextNode.getNextNode();
        }


    }
}
