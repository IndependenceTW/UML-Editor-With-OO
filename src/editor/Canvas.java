package editor;

import mode.Mode;
import shape.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Canvas extends JPanel {
    //singleton
    private static Canvas _instance;
    private ArrayList<Shape> componentList = new ArrayList<>();
    private Mode mode;

    private Canvas() {
        //initial canvas
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        addMouseListener(new MouseListener());
        addMouseMotionListener(new MouseDragListener());
    }

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

        //todo paint components
        for(Shape s : componentList) {
            s.draw(g2d);
        }
    }
    public void setMode(Mode m) {
        cleanSelect();
        repaint();
        mode = m;
    }
    public void addShape(Shape component) {
        componentList.add(component);
    }
    public void removeShape(Shape target) {
        componentList.remove(target);
    }
    public Shape getPointObject(int x, int y) {
        Shape object = null;
        for(Shape component : componentList) {
            if(component.isPointIn(x, y)) {
                object = component;
            }
        }
        return object;
    }
    public void cleanSelect() {
        for(Shape component : componentList) {
            component.setSelected(false);
        }
    }
    public void setSelect(int x1, int y1, int x2, int y2) {
        for(Shape component : componentList) {
            boolean result = component.isInRange(x1, y1, x2, y2);
            component.setSelected(result);
        }
    }
    public ArrayList<Shape> getAllSelect() {
        ArrayList<Shape> selectObject = new ArrayList<>();
        for(Shape component : componentList) {
            if(component.getSelected()) {
                selectObject.add(component);
            }
        }
        return selectObject;
    }

    private class MouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            mode.onMousePressed(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            mode.onMouseReleased(e);
        }
    }

    private class MouseDragListener extends MouseAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            mode.onMouseDragged(e);
        }
    }
}
