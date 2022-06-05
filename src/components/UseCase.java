package components;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class UseCase extends Object{

    public UseCase(int x, int y) {
        super(x, y, 100, 60);
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);

        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, width, height);

        FontMetrics fm = g.getFontMetrics();
        Rectangle2D r = fm.getStringBounds(name, g);
        int nameX = x + (width - (int)r.getWidth()) / 2;
        int nameY = y + (height - (int)r.getHeight()) / 2 + fm.getAscent();
        g.drawString(name, nameX, nameY);
    }
}
