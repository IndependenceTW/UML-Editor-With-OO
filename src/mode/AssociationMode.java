package mode;

import shape.Association;

import java.awt.event.MouseEvent;

public class AssociationMode extends LineMode{
    @Override
    public void onMousePressed(MouseEvent e) {
        line = createLine(e.getX(), e.getY(), new Association());

        if(line != null) {
            canvas.addShape(line);
            canvas.repaint();
        }
    }
}
