package mode;

import shape.Composition;

import java.awt.event.MouseEvent;

public class CompositionMode extends LineMode{
    @Override
    public void onMousePressed(MouseEvent e) {
        line = createLine(e.getX(), e.getY(), new Composition());

        if(line != null) {
            canvas.addShape(line);
            canvas.repaint();
        }
    }
}
