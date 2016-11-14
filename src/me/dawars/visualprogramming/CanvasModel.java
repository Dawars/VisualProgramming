package me.dawars.visualprogramming;

import me.dawars.visualprogramming.nodes.Connection;
import me.dawars.visualprogramming.nodes.INode;

import java.util.ArrayList;

/**
 * Created by dawars on 11/14/16.
 */
public class CanvasModel {

    ArrayList<INode> nodes = new ArrayList<>(); // sorted in topological order prior executing
    ArrayList<Connection> connections = new ArrayList<>();
}
