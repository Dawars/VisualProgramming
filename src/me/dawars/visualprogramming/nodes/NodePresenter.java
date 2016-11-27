package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;
import me.dawars.visualprogramming.nodes.view.NodeView;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;


/**
 * Created by dawars on 11/24/16.
 */
public abstract class NodePresenter implements INode, Serializable {

    protected ArrayList<InputPin> inPins = new ArrayList<>();
    protected ArrayList<OutputPin> outPins = new ArrayList<>();

    NodeView view;

    public NodePresenter() {
        view = new NodeView(this);
    }


    public void setPosition(int x, int y) {
        view.setPosition(x, y);
    }

    public abstract String getName();

    public void render(Graphics2D graphics) {
        view.render(graphics);
    }

    public ArrayList<OutputPin> getOutPins() {
        return outPins;
    }

    public ArrayList<InputPin> getInPins() {
        return inPins;
    }

    protected void addInPin(InputPin<Double> inputPin) {
        inPins.add(inputPin);
    }

    protected void addOutPin(OutputPin<Double> outputPin) {
        outPins.add(outputPin);
    }
}
