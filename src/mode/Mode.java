package mode;

import ui.Canvas;

import java.awt.event.MouseEvent;

public abstract class Mode {
    protected Canvas canvas;
    public Mode(){
        canvas = Canvas.getInstance();
    }

    abstract public void onPressed(MouseEvent e);
    abstract public void onDragged(MouseEvent e);
    abstract public void onReleased(MouseEvent e);
}
