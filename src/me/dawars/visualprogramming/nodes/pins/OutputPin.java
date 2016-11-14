package me.dawars.visualprogramming.nodes.pins;

import me.dawars.visualprogramming.nodes.Connection;
import me.dawars.visualprogramming.nodes.INode;

import java.util.ArrayList;

/**
 * Created by dawars on 26/09/16.
 */
public class OutputPin<T> implements IPin {
    private T value;
    private INode node;

    public ArrayList<Connection<T>> connections = new ArrayList<>();

    public OutputPin(INode node) {
        this.node = node;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void connectTo(InputPin<T> in) {
        Connection<T> connection = new Connection<>(this, in);
        breakConnection(in);

        this.connections.add(connection); // add new connection
        in.connection = connection; // set other half of connection
    }

    private void breakConnection(InputPin<T> in) {
        if (in.connection != null)
            in.connection.outPin.connections.remove(in.connection); // remove other half of connection
        this.connections.remove(in.connection); // remove if already connected
    }
}
