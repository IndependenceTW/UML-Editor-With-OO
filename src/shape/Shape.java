package shape;

import java.awt.*;
import java.util.ArrayList;

public abstract class Shape {
    protected boolean isSelected = false;
    protected int x1, y1, x2, y2;

    //Constructor
    public Shape() {}
    public Shape(int x, int y) {
        x1 = x;
        y1 = y;
    }

    //abstract method
    public abstract void draw(Graphics2D g);
    public abstract void setPosition(int x, int y);

    //getter and setter
    public void setSelected(boolean b) {
        isSelected = b;
    }

    //percolating up
    public boolean isPointIn(int x, int y) {
        return false;
    }
    public boolean isInRange(int x1, int y1, int x2, int y2) {
        return false;
    }
    public Port getPort(int x, int y) {
        return null;
    }
    public boolean getSelected() {
        return isSelected;
    }
    public void move(int x, int y) {
        setPosition(x + x1, y + y1);
    };
    public boolean isGroup() {
        return false;
    };
    public ArrayList<Shape> getElements() {
        return null;
    }
    public String getName() {
        return null;
    }
    public void setName(String name) {}
}
