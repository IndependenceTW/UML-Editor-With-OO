package shape;

import java.awt.*;

public class Port extends Shape{
    static final int SIZE = 8;
    int nearX;
    int nearY;

    public Port(int x, int y, int nearX, int nearY) {
        super(x, y);
        this.nearX = nearX;
        this.nearY = nearY;
    }
    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.drawRect(x1, y1, SIZE, SIZE);
        g.setColor(Color.BLACK);
    }

    @Override
    public void setPosition(int x, int y) {
        x1 = x;
        y1 = y;
    }

    public void move(int x, int y) {
        super.move(x, y);
        nearX += x;
        nearY += y;
    }

    public int getNearX() {
        return nearX;
    }
    public int getNearY() {
        return nearY;
    }
}
