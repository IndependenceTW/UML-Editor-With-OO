package shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class GroupObject extends Shape{
    protected ArrayList<Shape> elements = new ArrayList<>();
    public GroupObject(ArrayList<Shape> targetObj) {
        elements = targetObj;
        x1 = elements.get(0).x1;
        y1 = elements.get(0).y1;
        x2 = elements.get(0).x2;
        y2 = elements.get(0).y2;

        for (Shape element : elements) {
            x1 = min(x1, element.x1);
            y1 = min(y1, element.y1);
            x2 = max(x2, element.x2);
            y2 = max(y2, element.y2);
        }

        x1 -= 5;
        y1 -= 5;
        x2 += 5;
        y2 += 5;
    }
    @Override
    public void draw(Graphics2D g) {
        if(isSelected) {
            g.setColor(Color.RED);
            g.drawRect(x1, y1, x2 - x1, y2 - y1);
        }
        g.setColor(new Color(250,128,114, 50));
        g.fillRect(x1, y1, x2 - x1, y2 - y1);
        g.setColor(Color.BLACK);

        for(Shape element : elements) {
            element.draw(g);
        }
    }
    @Override
    public void setPosition(int x, int y) {
        int diffX = x - x1;
        int diffY = y - y1;

        for(Shape element : elements) {
            element.move(diffX, diffY);
        }
        x1 = x;
        y1 = y;
        x2 += diffX;
        y2 += diffY;
    }
    @Override
    public boolean isPointIn(int x, int y) {
        return x >= x1 && y >= y1 && x <= x2 && y <= y2;
    }
    @Override
    public boolean isInRange(int x1, int y1, int x2, int y2) {
        if(x1 > x2) {
            x2 += x1;
            x1 = x2 - x1;
            x2 -= x1;
        }
        if(y1 > y2) {
            y2 += y1;
            y1 = y2 - y1;
            y2 -= y1;
        }

        return x1 <= this.x1 && y1 <= this.y1 && x2 >= this.x2 && y2 >= this.y2;
    }
    @Override
    public void setSelected(boolean b) {
        super.setSelected(b);
        for(Shape element : elements){
            element.setSelected(b);
        }
    }
    @Override
    public boolean isGroup() {
        return true;
    }

    @Override
    public ArrayList<Shape> getElements() {
        return elements;
    }
}
