package components;

import java.awt.*;

public class Port extends Shape{
    protected enum Position {UP, DOWN, LEFT, RIGHT}
    protected final static int SIZE = 8;
    protected Position p;

    protected Port(int x, int y, Position p) {
        super(x, y, SIZE, SIZE);
        this.p = p;
    }

    public int getNearX() {
        if(p == Position.UP || p == Position.DOWN) {
            return this.x + SIZE / 2;
        }
        else if(p == Position.LEFT) {
            return this.x + SIZE;
        }
        else {
            return this.x;
        }
    }

    public int getNearY() {
        if(p == Position.LEFT || p == Position.RIGHT) {
            return this.y + SIZE / 2;
        }
        else if(p == Position.UP) {
            return this.y + SIZE;
        }
        else {
            return this.y;
        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
        g.setColor(Color.RED);
        g.drawRect(x, y, width, height);
        g.setColor(Color.BLACK);
    }
}
