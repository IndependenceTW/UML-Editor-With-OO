package mode;

import shape.Line;
import shape.Port;
import shape.Shape;

import java.awt.event.MouseEvent;

public class LineMode extends Mode{
    Line line;
    Shape beginShape;
    @Override
    public void onMousePressed(MouseEvent e) {
        line = createLine(e.getX(), e.getY(), new Line());

        if(line != null) {
            canvas.addShape(line);
            canvas.repaint();
        }
    }

    @Override
    public void onMouseReleased(MouseEvent e) {
        if(line == null) {
            return;
        }

        Shape endObject = canvas.getPointObject(e.getX(), e.getY());
        if(endObject == null || endObject == beginShape) {
            canvas.removeShape(line);
            canvas.repaint();
            return;
        }

        line.setEnd(endObject.getPort(e.getX(), e.getY()));
        canvas.repaint();
    }

    @Override
    public void onMouseDragged(MouseEvent e) {
        if(line != null) {
            line.setPosition(e.getX(), e.getY());
            canvas.repaint();
        }
    }

    protected Line createLine(int x, int y, Line creation) {
        Shape beginShape = canvas.getPointObject(x, y);
        if(beginShape == null) {
            return null;
        }
        Port beginPort = beginShape.getPort(x, y);
        if(beginPort == null) {
            return null;
        }
        creation.setStart(beginPort);
        creation.setPosition(x, y);
        this.beginShape = beginShape;
        return creation;
    }
}
