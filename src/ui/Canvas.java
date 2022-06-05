package ui;

import components.*;
import components.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JPanel {
    private static Canvas _instance;
    private ArrayList<Shape> components;

    private Canvas() {
        components = new ArrayList<>();
        ClassObject a1 = new ClassObject(10,10);
        UseCase a2 = new UseCase(500,500);
        components.add(a1);
        components.add(a2);
        components.add(new Generation(a1.ports[1], a2.ports[2]));

        //initial canvas
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }

    //for singleton
    public static Canvas getInstance() {
        if(_instance == null) {
            _instance = new Canvas();
        }
        return _instance;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        //draw setting
        g2d.setStroke(new BasicStroke(3));
        g2d.setFont(new Font("Noto Sans TC", Font.BOLD, 16));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);

        for(Shape component : components) {
            component.draw(g2d);
        }
    }
}
