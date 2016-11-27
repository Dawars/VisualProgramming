package me.dawars.visualprogramming.nodes.pins;

import java.io.Serializable;

/**
 * Created by dawars on 11/14/16.
 */
public interface IPin extends Serializable {
    int getX();
    int getY();
    void clicked();
    boolean isInput();
}
