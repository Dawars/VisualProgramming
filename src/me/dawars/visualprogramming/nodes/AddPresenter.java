package me.dawars.visualprogramming.nodes;

import me.dawars.visualprogramming.nodes.pin.InPin;
import me.dawars.visualprogramming.nodes.pin.OutPin;

/**
 * Created by dawars on 11/13/16.
 */
public class AddPresenter<T> extends NodePresenter {

    InPin<T> inA = new InPin<>();
    InPin<T> inB = new InPin<>();
    OutPin<T> out = new OutPin<>();


    @Override
    void execute() {
        out.setValue(inA.getValue() + inB.getValue()); // I can't solve this
    }
}
