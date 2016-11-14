package me.dawars.visualprogramming;

/**
 * Created by dawars on 26/09/16.
 */
public class App {

    private final Model model;

    public static void main(String[] args) {
        System.out.println("---Dawars Visual Programming---");

        new App();
    }

    public App() {
        this.model = new Model();// idk

        Canvas canvas = new Canvas();
    }
}
