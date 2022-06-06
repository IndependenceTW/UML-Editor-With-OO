package ui;

import components.Shape;
import mode.ClassMode;
import mode.Mode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Canvas extends JPanel {
    private static Canvas _instance;
    private ArrayList<Shape> components;
    private static Mode mode;

    private Canvas() {
        components = new ArrayList<>();
        //initial canvas
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        addMouseListener(new MouseListener());
        addMouseMotionListener(new MouseDragListener());
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
        g2d.setStroke(new BasicStroke(2));
        g2d.setFont(new Font("Noto Sans TC", Font.BOLD, 16));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);

        for(Shape component : components) {
            component.draw(g2d);
        }
    }

    public void add(Shape s) {
        components.add(s);
        repaint();
    }

    public void setMode(Mode m) {
        mode = m;
    }

    public Shape getClickObject(int x, int y) {
        Shape ret = null;
        for(Shape component : components) {
            if(component.isInObject(x, y)) {
                ret = component;
            }
        }
        return ret;
    }

    public ArrayList<Shape> getRangeObject(int x1, int y1, int x2, int y2) {
        ArrayList<Shape> ret = new ArrayList<Shape>();
        for(Shape component : components) {
            if(component.isInRange(x1, y1, x2, y2)) {
                ret.add(component);
            }
        }
        return ret;
    }

    private static class MouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            mode.onPressed(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            mode.onReleased(e);
        }
    }

    private static class MouseDragListener extends MouseAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            mode.onDragged(e);
        }
    }
}
