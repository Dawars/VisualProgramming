package me.dawars.visualprogramming.canvas;

import me.dawars.visualprogramming.ColorPresenter;
import me.dawars.visualprogramming.TopologicalSort;
import me.dawars.visualprogramming.nodes.*;
import me.dawars.visualprogramming.nodes.pins.IPin;
import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Created by dawars on 11/14/16.
 */
public class CanvasPresenter implements MouseListener, MouseInputListener, Serializable {
    private final RenderNode start;
    public final CanvasView view;
    private CanvasModel model;
    private NodePresenter selectedNode;
    private IPin selectedPin;
    private ColorPresenter colorComponent;

    public void setColorComponent(ColorPresenter colorComponent) {
        this.colorComponent = colorComponent;
    }

    public enum MouseState {NONE, MOVING, CONNECTING}

    private MouseState mouseState = MouseState.NONE;

    public CanvasPresenter() {
        view = new CanvasView(CanvasPresenter.this);
        model = new CanvasModel();

        // Start
        start = new RenderNode();
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
            String s = (String) JOptionPane.showInputDialog(
                    new JFrame(),
                    "Type in a number:",
                    "Set the value of the constant",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "1.0");
            if ((s != null) && (s.length() > 0)) {
                double num = Double.parseDouble(s);
                ((ConstantNode) newNode).getOut().setValue(num);
            }
        } else if (node instanceof CosNode) {
            newNode = new CosNode();
        } else if (node instanceof LerpNode) {
            newNode = new LerpNode();
        } else if (node instanceof AbsNode) {
            newNode = new AbsNode();
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

    private Deque<NodePresenter> topoSort = new ArrayDeque<>();
    private TopologicalSort topo = new TopologicalSort();

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

            Connection otherConn = connection.inPin.connection;
            if (otherConn != null) {
                model.removeConnection(otherConn);
            }
            out.connect(connection);////////////////////////////

            model.addConnection(connection);
            calcTopoSort();
        }
        return cycle;
    }

    private CanvasThread thread;

    public void run() {
        calcTopoSort();
        stop();
        thread = new CanvasThread(topoSort, colorComponent);
        thread.isRunning = true;
        thread.execute();
    }

    public void stop() {
        if (thread != null) {
            thread.isRunning = false;
            thread.cancel(true);
        }
    }

    private void calcTopoSort() {
        topoSort.clear();
        topoSort.addAll(topo.topSort(getNodes()));
    }

    private NodePresenter getClickedNode(int x, int y) {
        NodePresenter node;
        for (int i = 0; i < getNodes().size(); i++) {
            node = getNodes().get(i);
            if (node.getBoundingBox().contains(x, y)) {
                return node;
            }
        }

        return null;
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

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

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
