package shape;

import java.awt.*;

public class Line extends Shape{
    Port begin;
    Port end;

    //constructor
    public Line() {
        super();
    }

    //todo abstract drawArrow
    protected void drawArrow(Graphics2D g, int x1, int y1, int x2, int y2) {

    }

    @Override
    public void draw(Graphics2D g) {
        x1 = begin.getNearX();
        y1 = begin.getNearY();
        if(end != null) {
            x2 = end.getNearX();
            y2 = end.getNearY();
        }


        g.drawLine(x1, y1, x2, y2);
        drawArrow(g, x1, y1, x2, y2);
    }

    @Override
    public void setPosition(int x, int y) {
        x2 = x;
        y2 = y;
    }

    public void setEnd(Port end) {
        x2 = end.getNearX();
        y2 = end.getNearY();
        this.end = end;
    }
    public void setStart(Port begin) {
        x1 = begin.getNearX();
        y1 = begin.getNearY();
        this.begin = begin;
    }
}
