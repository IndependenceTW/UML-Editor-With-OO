package mode;

import shape.ClassObject;
import shape.Object;

import java.awt.event.MouseEvent;

public class ClassMode extends Mode{

    @Override
    public void onMousePressed(MouseEvent e) {
        canvas.addShape(new ClassObject(e.getX(), e.getY()));
        canvas.repaint();
    }

    @Override
    public void onMouseReleased(MouseEvent e) {

    }

    @Override
    public void onMouseDragged(MouseEvent e) {

    }
}
