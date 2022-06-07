package shape;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class UseCase extends Object{
    public UseCase(int x, int y) {
        super(x, y, 100, 80);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillOval(x1, y1, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        g.drawOval(x1, y1, WIDTH, HEIGHT);

        FontMetrics fm = g.getFontMetrics();
        Rectangle2D r = fm.getStringBounds(name, g);
        int x = x1 + (WIDTH - (int)r.getWidth()) / 2;
        int y = y1 + (HEIGHT - (int)r.getHeight()) / 2 + fm.getAscent();
        g.drawString(name, x, y);

        if(isSelected) {
            drawPorts(g);
        }
    }
}
