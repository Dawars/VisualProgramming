package me.dawars.visualprogramming.nodes;

/**
 * Created by dawars on 11/8/16.
 */
public class ConstNodePresenter extends NodePresenter {

    public   ConstNodePresenter(){
        super();
        model = new ConstNodeModel();//pins...
        view = new ConstNodeView();
    }
}
