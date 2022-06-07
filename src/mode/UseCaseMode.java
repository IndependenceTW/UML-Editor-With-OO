package mode;

import shape.UseCase;

import java.awt.event.MouseEvent;

public class UseCaseMode extends Mode{
    @Override
    public void onMousePressed(MouseEvent e) {
        canvas.addShape(new UseCase(e.getX(), e.getY()));
        canvas.repaint();
    }

    @Override
    public void onMouseReleased(MouseEvent e) {

    }

    @Override
    public void onMouseDragged(MouseEvent e) {

    }
}
