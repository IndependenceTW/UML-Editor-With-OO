package mode;

import components.ClassObject;

import java.awt.event.MouseEvent;

public class ClassMode extends Mode{

    @Override
    public void onPressed(MouseEvent e) {
        canvas.add(new ClassObject(e.getX(), e.getY()));
    }

    @Override
    public void onDragged(MouseEvent e) {

    }

    @Override
    public void onReleased(MouseEvent e) {

    }
}

