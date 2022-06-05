package components;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class ClassObject extends Object{
    public ClassObject(int x, int y) {
        super(x, y, 100, 120);
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);

        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
        g.drawLine(x, y + height / 3, x + width, y + height / 3);
        g.drawLine(x, y + height * 2 / 3, x + width, y + height * 2 / 3);

        FontMetrics fm = g.getFontMetrics();
        Rectangle2D r = fm.getStringBounds(name, g);
        int nameX = x + (width - (int)r.getWidth()) / 2;
        int nameY = y + (height / 3 - (int)r.getHeight()) / 2 + fm.getAscent();
        g.drawString(name, nameX, nameY);
    }
}
