package components;

import java.awt.*;

public abstract class Line extends Shape{
    protected Port from;
    protected Port to;

    public Line(Port from, Port to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void draw(Graphics2D g) {
        int x1 = from.getNearX();
        int y1 = from.getNearY();
        int x2 = to.getNearX();
        int y2 = to.getNearY();

        g.drawLine(x1, y1, x2, y2);
        drawArrow(g, x1, y1, x2, y2);
    }

    protected abstract void drawArrow(Graphics2D g, int x1, int y1, int x2, int y2);
}
