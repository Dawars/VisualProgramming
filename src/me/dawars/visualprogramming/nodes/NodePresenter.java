package me.dawars.visualprogramming.nodes;

/**
 * Created by dawars on 11/8/16.
 */
public abstract class NodePresenter<T> {

//    private NodeModel<T> model;
    private NodeView view;

    abstract void execute();

    public void onClick(){

    }
}
