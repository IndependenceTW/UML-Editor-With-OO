package shape;

import java.awt.*;

public class ClassObject extends Object{
    public ClassObject(int x, int y) {
        super(x, y, 100, 120);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(x1, y1, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        g.drawRect(x1, y1, WIDTH, HEIGHT);
        g.drawLine(x1, y1 + HEIGHT / 3, x1 + WIDTH, y1 + HEIGHT / 3);
        g.drawLine(x1, y1 + HEIGHT * 2 / 3, x1 + WIDTH, y1 + HEIGHT * 2 / 3);

        if(isSelected) {
            drawPorts(g);
        }
    }
}
