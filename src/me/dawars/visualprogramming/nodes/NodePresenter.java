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

    /**
     * Set the position of NodeView
     * @param x
     * @param y
     */
    public void setPosition(int x, int y) {
        view.setPosition(x, y);
    }

    /**
     * Gives the name of the node
     * @return name
     */
    public abstract String getName();

    /**
     * Renders the node
     * @param graphics
     */
    public void render(Graphics2D graphics) {
        view.render(graphics);
    }

    /**
     * Returns the list of OutputPins
     * @return output pins
     */
    public ArrayList<OutputPin> getOutPins() {
        return outPins;
    }

    /**
     * Returns the list of InputPins
     * @return input pins
     */
    public ArrayList<InputPin> getInPins() {
        return inPins;
    }

    /**
     * Register inPin
     * @param inputPin
     */
    protected void addInPin(InputPin<Double> inputPin) {
        inputPin.calcPosition(inPins.size());
        inPins.add(inputPin);
    }

    /**
     * Register outPin
     * @param outputPin
     */
    protected void addOutPin(OutputPin<Double> outputPin) {
        outputPin.calcPosition(outPins.size());
        outPins.add(outputPin);
    }

    /**
     * Get BoundingBox of node
     * @return
     */
    public Rectangle getBoundingBox() {
        return view.getBoundingBox();
    }

    /**
     * Handle click event at x, y
     * @param x coord
     * @param y coord
     * @return clicked pin
     */
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

    /**
     * Deselect node
     */
    public void deselect() {
        isSelected = false;
    }

    /**
     * Select node
     */
    public void select() {
        isSelected = true;
    }

    /**
     * @return if node is selected
     */
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
