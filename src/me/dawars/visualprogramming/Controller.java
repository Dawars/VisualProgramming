package me.dawars.visualprogramming;

import me.dawars.visualprogramming.nodes.DataNode;
import me.dawars.visualprogramming.nodes.ExecutableNode;
import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutExecutionPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

import java.util.ArrayList;

/**
 * Created by dawars on 10/4/16.
 */
public class Controller {

//    ArrayList<DataConnection> connectionGraph;

    /**
     * Connect InputPin to OutputPin
     *
     * @return true if connection is successful
     */
    public static boolean connectDataNodes(InputPin in, OutputPin out) {
        // TODO: add to graph and check for cycle -> return false

        // TODO: check data type

        in.connectTo(out);

        return true;
    }

    public static void breakDataConnection(InputPin in, OutputPin out){
        //TODO: implement
    }

    public static void deleteDataNode(DataNode node){
        // TODO: implement
    }

    /**
     * Connect ExecutionPin to Node
     *
     * @return true if connection is successful, needed ?
     */
    public static boolean connectExecutableNodes(OutExecutionPin pin, ExecutableNode node) {

        pin.connectTo(node);

        return true;
    }

    public static void deleteExecutableNode(ExecutableNode node){
        // store in connections too?? how to delete that
        // delete in connections
        // how to delete out connections? reversed direction
    }
}
