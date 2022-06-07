package shape;

import java.awt.*;
import java.awt.geom.Rectangle2D;

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

        FontMetrics fm = g.getFontMetrics();
        Rectangle2D r = fm.getStringBounds(name, g);
        int x = x1 + (WIDTH - (int)r.getWidth()) / 2;
        int y = y1 + (HEIGHT / 3 - (int)r.getHeight()) / 2 + fm.getAscent();
        g.drawString(name, x, y);

        if(isSelected) {
            drawPorts(g);
        }
    }
}
