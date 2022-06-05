package ui;

import javax.swing.*;
import java.awt.*;

public class Editor extends JFrame {
    private final int height = 900;
    private final int width = 1600;
    private JMenuBar menuBar;
    private JToolBar toolBar;
    private JPanel canvas;

    public Editor() {
        //Initial Components
        menuBar = new MenuBar();
        toolBar = new ToolBar();
        canvas = Canvas.getInstance();

        //Initial Frames
        setLayout(new BorderLayout());
        setTitle("UML Editor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width, height);

        //Add components
        add(toolBar, BorderLayout.WEST);
        add(canvas, BorderLayout.CENTER);
        setJMenuBar(menuBar);
    }
}
