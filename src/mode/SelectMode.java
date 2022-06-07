package mode;

import shape.Shape;
import shape.SelectShape;

import java.awt.event.MouseEvent;

public class SelectMode extends Mode{
    Shape selectTarget;
    SelectShape selectShape;

    int preX;
    int preY;

    @Override
    public void onMousePressed(MouseEvent e) {
        canvas.cleanSelect();
        preX = e.getX();
        preY = e.getY();

        selectTarget = canvas.getPointObject(preX, preY);
        if(selectTarget == null) {
            selectShape = new SelectShape(preX, preY);
            selectShape.setPosition(preX, preY);
            canvas.addShape(selectShape);
        }
        else {
            selectTarget.setSelected(true);
        }

        canvas.repaint();
    }

    @Override
    public void onMouseReleased(MouseEvent e) {
        if(selectShape != null) {
            canvas.removeShape(selectShape);
            selectShape = null;
        }

        canvas.repaint();
    }

    @Override
    public void onMouseDragged(MouseEvent e) {
        if(selectShape != null) {
            selectShape.setPosition(e.getX(), e.getY());
            canvas.setSelect(preX, preY, e.getX(), e.getY());
        }
        if(selectTarget != null) {
            selectTarget.setPosition(e.getX(), e.getY());
        }

        canvas.repaint();
    }
}
