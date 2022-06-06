package components;


import java.awt.*;

public abstract class Shape {
    protected int x, y, width, height;
    protected Shape() {}
    protected Shape(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void draw(Graphics2D g);

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    //percolating up
    public boolean isInRange(int x1, int y1, int x2, int y2){ return false; }
    public boolean isInObject(int x, int y){ return false; }
    public Port getPort(int x, int y) { return null; }
    public void unGroup(){}
    public void setName(String name){}
}
