package me.dawars.visualprogramming.canvas;

import me.dawars.visualprogramming.nodes.Connection;
import me.dawars.visualprogramming.nodes.INode;
import me.dawars.visualprogramming.nodes.NodePresenter;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by dawars on 11/14/16.
 */
public class CanvasModel implements Serializable{

    ArrayList<NodePresenter> nodes = new ArrayList<>(); // sorted in topological order prior executing
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
}
