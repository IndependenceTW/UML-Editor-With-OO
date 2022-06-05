package components;

import java.awt.*;

public abstract class Object extends Shape{
    protected String name;

    protected Object(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.name = "object";
    }

    public boolean isInRange(int x1, int y1, int x2, int y2){
        return (x >= Math.min(x1, x2)) && (y >= Math.min(y1, y2))
                && ((x + width) <= Math.max(x1, x2)) && ((y + height) <= Math.max(y1, y2));
    }

    public boolean isInObject(int x, int y){
        int diffX = x - this.x;
        int diffY = y - this.y;

        return (diffX >= 0) && (diffY >= 0) && (diffX <= width) && (diffY <= height);
    }

    public void setName(String name) {
        this.name = name;
    }

}
