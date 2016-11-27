package me.dawars.visualprogramming.canvas;

import me.dawars.visualprogramming.nodes.Connection;
import me.dawars.visualprogramming.nodes.INode;
import me.dawars.visualprogramming.nodes.NodePresenter;
import me.dawars.visualprogramming.nodes.StartNode;
import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dawars on 11/14/16.
 */
public class CanvasModel implements Serializable {

    ArrayList<NodePresenter> nodes = new ArrayList<>(); // TODO sorted in topological order prior executing
    ArrayList<Connection> connections = new ArrayList<>();

    public ArrayList<Connection> getConnections() {
        return connections;
    }

    public ArrayList<NodePresenter> getNodes() {
        return nodes;
    }

    public void addConnection(Connection connection) {
        connections.add(connection);
    }

    public void addNodes(NodePresenter node) {
        nodes.add(node);
    }

    public void removeNode(NodePresenter node) {
        if (node == null || node instanceof StartNode) return;
        synchronized (connections) {
            for (InputPin in : node.getInPins()) {
                removeConnection(in.connection);
                connections.remove(in.connection);
            }
// FIXME remove connections, iterate through connections, works for small graphs
            for (OutputPin in : node.getOutPins()) {
                List<Connection> conns = in.connections;
                for (Connection conn : conns) {
//                    removeConnection(conn);
                    connections.remove(conn);
                }
            }
        }
        nodes.remove(node);
    }

    private void removeConnection(Connection conn) {
        if (conn == null) return;
        conn.outPin.connections.remove(conn);
        conn.inPin.connection = null;
    }
}
