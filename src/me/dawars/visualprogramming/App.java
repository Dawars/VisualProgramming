package me.dawars.visualprogramming;

import me.dawars.visualprogramming.nodes.AddNode;
import me.dawars.visualprogramming.nodes.ConstantNode;
import me.dawars.visualprogramming.nodes.PrintNode;
import me.dawars.visualprogramming.nodes.StartNode;

/**
 * Created by dawars on 26/09/16.
 */
public class App {

    public static void main(String[] args) {
        System.out.println("---Dawars Visual Programming---");

        // TODO: add Controller.connectPins(out, in)
        // which adds the connection to an arraylist
        // then calc the Topological sort and execute them (or calc it separately for data end execution)

        // and try to break UE4 Blueprint with loops :)


        // Start
        StartNode start = new StartNode();
        PrintNode<String> print = new PrintNode<>("Default text");
        start.outExecutionPin.connectTo(print);

        // Hello Node!
        ConstantNode<String> constant = new ConstantNode<>("Hello Node!");
        print.inPin.connectTo(constant.out);

        // Addition
        ConstantNode<Integer> a = new ConstantNode<>(1);
        ConstantNode<Integer> b = new ConstantNode<>(2);

        AddNode addNode = new AddNode();

        addNode.a.connectTo(a.out);
        addNode.b.connectTo(b.out);

        // Print sum
        PrintNode<Integer> printSum = new PrintNode<>();
        print.outExecutionPin.connectTo(printSum);
        printSum.inPin.connectTo(addNode.c);


        INode nextNode = start;
        while(nextNode != null){
            nextNode.execute();
            nextNode = nextNode.getNextNode();
        }


    }
}
