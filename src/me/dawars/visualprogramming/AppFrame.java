package me.dawars.visualprogramming;

import me.dawars.visualprogramming.canvas.CanvasPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * Created by dawars on 11/24/16.
 */
public class AppFrame extends JFrame {

    private final App app;
    private CanvasPresenter canvas;

    private final JTextArea console;
    private final JSplitPane right_side;
    private JSplitPane left_sidebar;

    /**
     * IView
     */
    public AppFrame(App app, CanvasPresenter canvas) {
        super("Visual Programming Editor");

        this.app = app;
        this.canvas = canvas;

        createMenuBar();

        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());


        JPanel toolBar = new JPanel();
        toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        toolBar.add(new JButton("Start"));
        toolBar.add(new JButton("Stop"));
        add(toolBar, BorderLayout.NORTH);

        JList<String> nodeList = new JList<>(new AbstractListModel<String>() {
            @Override
            public int getSize() {
                return App.getListNode().size();
            }

            @Override
            public String getElementAt(int i) {
                return App.getListNode().get(i).getName();
            }
        });

        left_sidebar = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(nodeList), new JPanel());
        left_sidebar.setDividerLocation(300);


        console = new JTextArea("Welcome to the Visual Programming Editor\n");
        right_side = new JSplitPane(JSplitPane.VERTICAL_SPLIT, canvas.view, new JScrollPane(console));
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left_sidebar, right_side);
        splitPane.setDividerLocation(150);

        add(splitPane, BorderLayout.CENTER);
        setVisible(true);
    }

    private void createMenuBar() {

        JMenuBar menubar = new JMenuBar();
//        ImageIcon icon = new ImageIcon("exit.png");

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenuItem eMenuItem = new JMenuItem("Exit");
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });


        JMenuItem sMenuItem = new JMenuItem("Save");
        sMenuItem.setMnemonic(KeyEvent.VK_S);
        sMenuItem.setToolTipText("Save current project");
        sMenuItem.addActionListener((ActionEvent event) -> {
            app.save();
        });
        JMenuItem saMenuItem = new JMenuItem("Save as...");
        saMenuItem.setMnemonic(KeyEvent.VK_A);
        saMenuItem.setToolTipText("Save current project as ...");
        saMenuItem.addActionListener((ActionEvent event) -> {
            app.save_as();
        });
        JMenuItem oMenuItem = new JMenuItem("Open");
        oMenuItem.setMnemonic(KeyEvent.VK_O);
        oMenuItem.setToolTipText("Open project");
        oMenuItem.addActionListener((ActionEvent event) -> {
            app.open();
        });
        JMenuItem nMenuItem = new JMenuItem("New");
        nMenuItem.setMnemonic(KeyEvent.VK_N);
        nMenuItem.setToolTipText("Empty project");
        nMenuItem.addActionListener((ActionEvent event) -> {
            app.newProject();
        });

        file.add(nMenuItem);
        file.add(sMenuItem);
        file.add(saMenuItem);
        file.add(oMenuItem);
        file.add(eMenuItem);

        menubar.add(file);

        setJMenuBar(menubar);

    }

    public void setLeftBottomComponent(JComponent component) {
        left_sidebar.setBottomComponent(component);
    }

    public JTextArea getConsole() {
        return console;
    }

    public void setCanvas(CanvasPresenter canvas) {
        this.canvas = canvas;
        right_side.setTopComponent(canvas.view);
    }
}
