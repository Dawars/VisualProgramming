package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 26/09/16.
 */
public class AddNode extends DataNode {
    public InputPin<Integer> inA = new InputPin<>();
    public InputPin<Integer> inB = new InputPin<>();
    public OutputPin<Integer> outC = new OutputPin<>(this);

    @Override
    public void evaluate() {
        System.out.println("[AddNode]");
        outC.setValue(inA.getValue() + inB.getValue());
    }
}
