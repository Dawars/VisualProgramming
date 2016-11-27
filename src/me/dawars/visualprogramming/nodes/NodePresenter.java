package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.IPin;
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
    private boolean isSelected = false;

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
        inputPin.calcPosition(inPins.size());
        inPins.add(inputPin);
    }

    protected void addOutPin(OutputPin<Double> outputPin) {
        outputPin.calcPosition(outPins.size());
        outPins.add(outputPin);
    }

    public Rectangle getBoundingBox() {
        return view.getBoundingBox();
    }

    public IPin click(int x, int y) {
        for (int i = 0; i < getInPins().size(); i++) {
            InputPin pin = getInPins().get(i);
            if (view.getInPinBB(i).contains(x, y)) {
                pin.clicked();
                return pin;
            }
        }

        for (int i = 0; i < getOutPins().size(); i++) {
            OutputPin pin = getOutPins().get(i);
            if (view.getOutPinBB(i).contains(x, y)) {
                pin.clicked();
                return pin;
            }
        }

        return null;
    }

    public void deselect() {
        isSelected = false;
    }

    public void select() {
        isSelected = true;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public IPin getClickedPin(int x, int y) {
        for (int i = 0; i < getInPins().size(); i++) {
            InputPin pin = getInPins().get(i);
            if (view.getInPinBB(i).contains(x, y)) {
                return pin;
            }
        }

        for (int i = 0; i < getOutPins().size(); i++) {
            OutputPin pin = getOutPins().get(i);
            if (view.getOutPinBB(i).contains(x, y)) {
                return pin;
            }
        }
        return null;
    }
}
