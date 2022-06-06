package mode;

import components.Association;
import components.Port;
import components.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class LineMode extends Mode{
    protected Port begin = null;
    protected Port end = null;

    @Override
    public void onPressed(MouseEvent e) {
        Shape object = canvas.getClickObject(e.getX(), e.getY());
        begin = object.getPort(e.getX(), e.getY());
    }

    @Override
    public void onDragged(MouseEvent e) {
        if(begin == null) {
            return;
        }
        canvas.repaint();
        Graphics2D g = (Graphics2D) canvas.getGraphics();
        g.drawLine(begin.getNearX(), begin.getNearY(), e.getX(), e.getY());
    }

    @Override
    public void onReleased(MouseEvent e) {
        if(begin == null) {
            return;
        }
        Shape object = canvas.getClickObject(e.getX(), e.getY());
        if(object == null) {
            begin = null;
            return;
        }
        end = object.getPort(e.getX(), e.getY());
        addLine();
        begin = null;
        end = null;
    }

    protected abstract void addLine();
}
