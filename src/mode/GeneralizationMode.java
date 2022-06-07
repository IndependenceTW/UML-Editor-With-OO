package mode;

import shape.Generalization;

import java.awt.event.MouseEvent;

public class GeneralizationMode extends LineMode{
    @Override
    public void onMousePressed(MouseEvent e) {
        line = createLine(e.getX(), e.getY(), new Generalization());

        if(line != null) {
            canvas.addShape(line);
            canvas.repaint();
        }
    }
}
