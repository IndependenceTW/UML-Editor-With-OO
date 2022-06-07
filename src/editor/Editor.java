package editor;

import javax.swing.*;
import java.awt.*;

public class Editor extends JFrame {
    private final int height = 900;
    private final int width = 1600;
    private final JMenuBar menuBar = new MenuBar();
    private final JToolBar toolBar = new ToolBar();
    private final JPanel canvas = Canvas.getInstance();;

    public Editor() {
        //Initial Frames
        setLayout(new BorderLayout());
        setTitle("UML Editor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width, height);

        //Add components
        add(toolBar, BorderLayout.WEST);
        add(canvas, BorderLayout.CENTER);
        setJMenuBar(menuBar);

        //show
        setVisible(true);
    }
}
