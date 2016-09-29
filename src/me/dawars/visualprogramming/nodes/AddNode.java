package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.INode;
import me.dawars.visualprogramming.nodes.pins.InputPin;
import me.dawars.visualprogramming.nodes.pins.OutputPin;

/**
 * Created by dawars on 26/09/16.
 */
public class AddNode implements INode {
    InputPin<Integer> a = new InputPin<>();
    InputPin<Integer> b = new InputPin<>();
    OutputPin<Integer> c = new OutputPin<>();

}
