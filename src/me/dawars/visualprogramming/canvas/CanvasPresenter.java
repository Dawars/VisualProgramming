package me.dawars.visualprogramming.canvas;

import me.dawars.visualprogramming.nodes.*;
import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

import javax.swing.event.MouseInputListener;
import java.awt.event.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by dawars on 11/14/16.
 */
public class CanvasPresenter implements MouseListener, MouseInputListener, Serializable {
    private final StartNode start;
    public final CanvasView view;
    private CanvasModel model;

    public CanvasPresenter() {

        view = new CanvasView(CanvasPresenter.this);
        model = new CanvasModel();

        // Start
        start = new StartNode();
        start.setPosition(400, 100);
        addNode(start);

/*        TimeNode time = new TimeNode();

        CosNode cos = new CosNode();

        MultiplyNode multiply = new MultiplyNode();

        ConstantNode constant = new ConstantNode();
        constant.setValue(5.);

        // test topological order
        addNode(time);
        addNode(cos);
        addNode(constant);
        addNode(multiply);


        // Connections
        connectPins(time.out, cos.in);
        connectPins(cos.out, multiply.inA);
        connectPins(constant.out, multiply.inB);
        connectPins(multiply.out, start.in);

        run();*/
    }

    public void addNode(NodePresenter node, int x, int y) {
        node.setPosition(x, y);
        model.addNodes(node);
        view.repaint();
    }

    public void addNode(NodePresenter node) {
        model.addNodes(node);
    }

    public List<NodePresenter> getNodes() {
        return model.getNodes();
    }

    public List<Connection> getConnections() {
        return model.getConnections();
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
            model.addConnection(connection);
        }
        return cycle;
    }

    public void run() {
        // topological sort

        for (INode node : model.getNodes()) {
            node.execute();
        }

//        System.out.println("The result: " + start.getInput().getValue());
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("[clicked] " + mouseEvent.getX() + ":" + mouseEvent.getY());
        addNode(new ConstantNode(), mouseEvent.getX(), mouseEvent.getY());
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

        System.out.println("[pressed] " + mouseEvent.getX() + ":" + mouseEvent.getY());
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

        System.out.println("[release] " + mouseEvent.getX() + ":" + mouseEvent.getY());
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

        System.out.println("[drag] " + mouseEvent.getX() + ":" + mouseEvent.getY());
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

        System.out.println("[move] " + mouseEvent.getX() + ":" + mouseEvent.getY());
    }
}
