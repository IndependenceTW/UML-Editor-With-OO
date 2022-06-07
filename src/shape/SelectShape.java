package shape;

import java.awt.*;

public class SelectShape extends Shape{

    public SelectShape(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics2D g) {
        int minX = Math.min(x1, x2);
        int minY = Math.min(y1, y2);
        int maxX = Math.max(x1, x2);
        int maxY = Math.max(y1, y2);

        g.setColor(new Color(137, 207, 240, 80));
        g.fillRect(minX, minY, maxX - minX, maxY - minY);

        g.setColor(Color.BLACK);
    }

    @Override
    public void setPosition(int x, int y) {
        x2 = x;
        y2 = y;
    }
}
