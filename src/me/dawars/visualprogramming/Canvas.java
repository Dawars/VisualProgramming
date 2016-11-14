package me.dawars.visualprogramming;

import me.dawars.visualprogramming.nodes.*;
import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 11/14/16.
 */
public class Canvas {
    private final StartNode start;
    private CanvasModel model;

    public Canvas() {
        this.model = new CanvasModel();

        // Start
        start = new StartNode();

        TimeNode time = new TimeNode();

        CosNode cos = new CosNode();

        MultiplyNode multiply = new MultiplyNode();

        ConstantNode constant = new ConstantNode();
        constant.setValue(5.);

        // test topological order
        addNode(time);
        addNode(cos);
        addNode(constant);
        addNode(multiply);
        addNode(start);



        // Connections
        connectPins(time.out, cos.in);
        connectPins(cos.out, multiply.inA);
        connectPins(constant.out, multiply.inB);
        connectPins(multiply.out, start.in);

        run();
    }

    public void addNode(INode node) {
        model.nodes.add(node);
    }

    /**
     * Connect to {@link INode}s through their {@link me.dawars.visualprogramming.nodes.pins.IPin}s
     *
     * @param out {@link OutputPin} of first {@link INode}
     * @param in  {@link InputPin} of second {@link INode}
     * @return true if connection successful (no cycle detected)
     */
    public boolean connectPins(OutputPin out, InputPin in) {
        Connection connection = new Connection(out, in);

        // run DAG test here

        boolean cycle = false; // TODO: detect cycle

        if (!cycle) {

            out.connectTo(in);
            model.connections.add(connection);
        }
        return cycle;
    }

    public void run() {
        // topological sort

        for (INode node : model.nodes) {
            node.execute();
        }

        System.out.println("The result: " + start.in.getValue());
    }
}
