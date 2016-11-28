package me.dawars.visualprogramming;

import me.dawars.visualprogramming.nodes.Connection;
import me.dawars.visualprogramming.nodes.NodePresenter;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

import java.io.Serializable;
import java.util.*;

/**
 * Created by dawars on 11/28/16.
 */
public class TopologicalSort implements Serializable{
    Deque<NodePresenter> stack = new ArrayDeque<>();
    Set<NodePresenter> visited = new HashSet<>();

    public Deque<NodePresenter> topSort(List<NodePresenter> nodes) {
        visited.clear();
        stack.clear();

        for (NodePresenter node : nodes) {
            if (visited.contains(node)) {

                continue;
            }

            topSortUtil(node);
        }
        return stack;
    }

    private void topSortUtil(NodePresenter vertex) {
        visited.add(vertex);
        for (OutputPin outputPin : vertex.getOutPins()) {
            List<Connection> conns = outputPin.connections;
            for (Connection conn : conns) {
                NodePresenter child = conn.inPin.getNode();

                if (visited.contains(child)) {
                    continue;
                }
                topSortUtil(child);
            }
        }
        stack.offerFirst(vertex);
    }
}
