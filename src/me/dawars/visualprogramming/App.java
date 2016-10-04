package me.dawars.visualprogramming;

import me.dawars.visualprogramming.nodes.*;

/**
 * Created by dawars on 26/09/16.
 */
public class App {

    public static void main(String[] args) {
        System.out.println("---Dawars Visual Programming---");

        // TODO: add Controller.connectPins(in, out)
        // which adds the connection to an arraylist
        // then calc the Topological sort and execute them (or calc it separately for data end execution)

        // and try to break UE4 Blueprint with loops :)


        // Start
        StartNode start = new StartNode();

        // print
        PrintNode<String> print = new PrintNode<>("Default text");
        ConstantNode<String> constant = new ConstantNode<>("Hello Node!");

        Controller.connectExecutableNodes(start.outExecutionPin, print);
        Controller.connectDataNodes(print.inPin, constant.out);



        // addition
        PrintNode<Integer> printInt = new PrintNode<>();
        ConstantNode<Integer> a = new ConstantNode<>(1);
        ConstantNode<Integer> b = new ConstantNode<>(2);
        AddNode addNode = new AddNode();


        Controller.connectExecutableNodes(print.outExecutionPin, printInt);
        Controller.connectDataNodes(printInt.inPin, addNode.outC);

        Controller.connectDataNodes(addNode.inA, a.out);
        Controller.connectDataNodes(addNode.inB, b.out);


        ExecutableNode nextNode = start;
        while(nextNode != null){
            nextNode.execute();
            nextNode = nextNode.getNextNode();
        }


    }
}
