package me.dawars.visualprogramming.canvas;

import me.dawars.visualprogramming.App;
import me.dawars.visualprogramming.nodes.*;
import me.dawars.visualprogramming.nodes.pins.IPin;
import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.List;

/**
 * Created by dawars on 11/14/16.
 */
public class CanvasPresenter implements MouseListener, MouseInputListener, Serializable {
    private final StartNode start;
    public final CanvasView view;
    private final App app;
    private CanvasModel model;
    private NodePresenter selectedNode;
    private IPin selectedPin;

    public enum MouseState {NONE, MOVING, CONNECTING}

    private MouseState mouseState = MouseState.NONE;

    public CanvasPresenter(App app) {
        this.app = app;
        view = new CanvasView(CanvasPresenter.this);
        model = new CanvasModel();

        // Start
        start = new StartNode();
        start.setPosition(400, 100);
        addNode(start);
    }

    public void addNode(NodePresenter node, int x, int y) {
        node.setPosition(x, y);
        model.addNodes(node);
        view.repaint();
    }

    public void addNode(NodePresenter node) {
        model.addNodes(node);
    }

    public void removeNode(NodePresenter node) {
        model.removeNode(node);
        view.repaint();
    }

    public void addNodeInstance(NodePresenter node) {
        NodePresenter newNode = null;
        if (node instanceof AddNode) {
            newNode = new AddNode();
        } else if (node instanceof ConstantNode) {
            newNode = new ConstantNode();
        } else if (node instanceof CosNode) {
            newNode = new CosNode();
        } else if (node instanceof LerpNode) {
            newNode = new LerpNode();
        } else if (node instanceof MultiplyNode) {
            newNode = new MultiplyNode();
        } else if (node instanceof OneMinusNode) {
            newNode = new OneMinusNode();
        } else if (node instanceof SinNode) {
            newNode = new SinNode();
        } else if (node instanceof TimeNode) {
            newNode = new TimeNode();
        }
        addNode(newNode, 10, 10);
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

    private NodePresenter getClickedNode(int x, int y) {
        NodePresenter node = null;
        for (int i = 0; i < getNodes().size(); i++) {
            node = getNodes().get(i);
            if (node.getBoundingBox().contains(x, y)) {
                return node;
            }
        }

        return null;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();

        NodePresenter node = getClickedNode(x, y);
        if (node != null) {
            node.click(x, y);
        }

        selectNode(node);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

        int x = mouseEvent.getX();
        int y = mouseEvent.getY();
        mousePt = mouseEvent.getPoint();

        System.out.println("[pressed] " + x + ":" + y);
        // TODO start drag

        NodePresenter node = getClickedNode(x, y);
        if (node != null) {
            IPin pin = node.getClickedPin(x, y);
            if (pin != null) {
                selectedPin = pin;
                mouseState = MouseState.CONNECTING;
            } else {
                selectNode(node);
                mouseState = MouseState.MOVING;
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        switch (mouseState) {
            case NONE:
                break;
            case MOVING:
                selectNode(null);
                break;
            case CONNECTING:
                int x = mouseEvent.getX();
                int y = mouseEvent.getY();
                NodePresenter node = getClickedNode(x, y);
                if (node != null) {
                    IPin pin = node.getClickedPin(x, y);
                    if (pin != null && selectedPin.isInput() != pin.isInput()) {
                        if (pin.isInput()) {
                            connectPins((OutputPin) selectedPin, (InputPin) pin);
                        } else {
                            connectPins((OutputPin) pin, (InputPin) selectedPin);
                        }
                    }
                }
                selectedPin = null;
                break;
        }
        mouseState = MouseState.NONE;
        view.repaint();
    }
    private Point mousePt;


    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        // update selection rect render,
        int dx = mouseEvent.getX() - mousePt.x;
        int dy = mouseEvent.getY() - mousePt.y;

        switch (mouseState) {
            case NONE:
                break;
            case MOVING:
                Rectangle boundingBox = selectedNode.getBoundingBox();
                selectedNode.setPosition(boundingBox.x + dx, boundingBox.y + dy);

                mousePt = mouseEvent.getPoint();
                break;
            case CONNECTING:
                mousePt = mouseEvent.getPoint();
                break;
        }
        view.repaint();
    }


    /**
     * Deselect nodes and select only node
     *
     * @param node
     */
    private void selectNode(NodePresenter node) {
        if (selectedNode != null) {
            selectedNode.deselect();
            selectedNode = null;
        }

        if (node != null) {
            node.select();
            selectedNode = node;
        }
        view.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

    //TODO const node popup

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }

    public NodePresenter getSelectedNode() {
        return selectedNode;
    }

    public MouseState getMouseState() {
        return mouseState;
    }

    public Point getMousePt() {
        return mousePt;
    }

    public IPin getSelectedPin() {
        return selectedPin;
    }
}
