package me.dawars.visualprogramming.garbage;

import javax.swing.*;

/**
 * Created by dawars on 11/7/16.
 */
public class AppView extends JFrame {
    // menu
    JMenuItem itemSave = new JMenuItem("Save"); // localize...
    JMenuItem itemLoad = new JMenuItem("Load"); // localize...


    public AppView() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // main window
        this.setTitle("Dawars Visual Programming");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);


        // menu
        JMenu menuFile = new JMenu("File");
        menuFile.add(itemSave);
        menuFile.add(itemLoad);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menuFile);

        this.setJMenuBar(menuBar);


        // side bar

        JList<String> list = new JList<>();
        list.setListData(new String[]{"Alma", "Korte", "Cseresznye"});

        JScrollPane panelScroll = new JScrollPane(list);
        add(panelScroll);

        //top bar


        //canvases

        setResizable(true);
        setVisible(true);
    }
}
