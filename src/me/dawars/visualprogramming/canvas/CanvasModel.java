package me.dawars.visualprogramming.canvas;

import me.dawars.visualprogramming.nodes.Connection;
import me.dawars.visualprogramming.nodes.NodePresenter;
import me.dawars.visualprogramming.nodes.RenderNode;
import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dawars on 11/14/16.
 */
public class CanvasModel implements Serializable {

    ArrayList<NodePresenter> nodes = new ArrayList<>(); // list of nodes on canvas
    ArrayList<Connection> connections = new ArrayList<>(); // list of connections between nodes

    /**
     * Returns connections array
     * @return
     */
    public ArrayList<Connection> getConnections() {
        return connections;
    }

    /**
     * Return nodes array
     * @return
     */
    public ArrayList<NodePresenter> getNodes() {
        return nodes;
    }

    /**
     * add connection to canvas
     * @param connection
     */
    public void addConnection(Connection connection) {
        connections.add(connection);
    }

    /**
     * Add nodes to canvas
     * @param node
     */
    public void addNodes(NodePresenter node) {
        nodes.add(node);
    }

    /**
     * Remove node from canvas
     * @param node
     */
    public void removeNode(NodePresenter node) {
        if (node == null || node instanceof RenderNode) return;
        // remove inpin connections
        for (InputPin in : node.getInPins()) {
            connections.remove(in.connection);
            removeConnection(in.connection);
        }
        //remove outpin connections from both sides
        for (OutputPin in : node.getOutPins()) {
            List<Connection> conns = in.connections;
            for (int i = 0; i < conns.size(); i++) {
                Connection conn = conns.get(i);

                removeConnection(conn);
                connections.remove(conn);
                i--;
            }
        }
        nodes.remove(node);
    }

    /**
     * Remove connection
     * @param conn
     */
    public void removeConnection(Connection conn) {
        if (conn == null) return;
        connections.remove(conn);
        conn.outPin.connections.remove(conn);
        conn.inPin.connection = null;
    }
}
