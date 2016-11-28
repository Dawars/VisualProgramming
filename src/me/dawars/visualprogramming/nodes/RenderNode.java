package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;

import java.awt.*;

/**
 * Created by dawars on 26/09/16.
 */
public class RenderNode extends NodePresenter {

    private InputPin<Double> inR = new InputPin<>(this, "Red");
    private InputPin<Double> inG = new InputPin<>(this, "Green");
    private InputPin<Double> inB = new InputPin<>(this, "Blue");

    public RenderNode() {
        addInPin(inR);
        addInPin(inG);
        addInPin(inB);
    }

    @Override
    public void execute() {
    }


    @Override
    public String getName() {
        return "Render Node";
    }

    public InputPin getInputR() {
        return inR;
    }

    public InputPin getInputG() {
        return inG;
    }

    public InputPin getInputB() {
        return inB;
    }

    public Color getColor() {
        Double r = inR.getValue();
        Double g = inG.getValue();
        Double b = inB.getValue();
        Color color = new Color(
                r == null ? 0.f : Math.max(0, Math.min(r.floatValue(), 1)),
                g == null ? 0.f : Math.max(0, Math.min(g.floatValue(), 1)),
                b == null ? 0.f : Math.max(0, Math.min(b.floatValue(), 1)));
        return color;
    }
}
