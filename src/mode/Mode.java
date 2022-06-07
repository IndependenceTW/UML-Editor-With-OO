package mode;

import editor.Canvas;

import java.awt.event.MouseEvent;

public abstract class Mode {
    protected Canvas canvas = Canvas.getInstance();
    public abstract void onMousePressed(MouseEvent e) ;
    public abstract void onMouseReleased(MouseEvent e) ;
    public abstract void onMouseDragged(MouseEvent e) ;
}
