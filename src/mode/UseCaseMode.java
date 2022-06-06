package mode;

import components.UseCase;

import java.awt.event.MouseEvent;

public class UseCaseMode extends Mode{

    @Override
    public void onPressed(MouseEvent e) {
        canvas.add(new UseCase(e.getX(), e.getY()));
    }

    @Override
    public void onDragged(MouseEvent e) {

    }

    @Override
    public void onReleased(MouseEvent e) {

    }
}

