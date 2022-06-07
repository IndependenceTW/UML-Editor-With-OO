package shape;

import java.awt.*;

public abstract class Object extends Shape{
    protected int HEIGHT;
    protected int WIDTH;
    protected Port[] ports = new Port[4];
    protected String name = "object";

    //Constructor
    public Object(int x, int y, int w, int h) {
        super(x, y);
        HEIGHT = h;
        WIDTH = w;
        x2 = x + w;
        y2 = y + h;
        setPort();
    }

    @Override
    public void setPosition(int x, int y) {
        for(Port p : ports) {
            p.move(x - x1, y - y1);
        }
        x1 = x;
        y1 = y;
        x2 = x + WIDTH;
        y2 = y + HEIGHT;
    }

    @Override
    public boolean isPointIn(int x, int y) {
        return x >= x1 && y >= y1 && x <= x1 + WIDTH && y <= y1 + HEIGHT;
    }
    @Override
    public boolean isInRange(int x1, int y1, int x2, int y2) {
        if(x1 > x2) {
            x2 = x2 + x1;
            x1 = x2 - x1;
            x2 = x2 - x1;
        }
        if(y1 > y2) {
            y2 = y2 + y1;
            y1 = y2 - y1;
            y2 = y2 - y1;
        }

        return x1 < this.x1 && y1 < this.y1 && x2 > this.x1 + WIDTH && y2 > this.y1 + HEIGHT;
    }

    protected void setPort() {
        //up
        ports[0] = new Port(x1 + WIDTH / 2 - Port.SIZE / 2, y1 - Port.SIZE ,x1 + WIDTH / 2, y1);
        //down
        ports[1] = new Port(x1 + WIDTH / 2 - Port.SIZE / 2, y1 + HEIGHT, x1 + WIDTH / 2, y1 + HEIGHT);
        //left
        ports[2] = new Port(x1 - Port.SIZE, y1 + HEIGHT / 2 - Port.SIZE / 2, x1, y1 + HEIGHT / 2);
        //right
        ports[3] = new Port(x1 + WIDTH,y1 + HEIGHT / 2 - Port.SIZE / 2,x1 + WIDTH,y1 + HEIGHT / 2);
    }

    protected void drawPorts(Graphics2D g) {
        for(Port p : ports) {
            p.draw(g);
        }
    }

    @Override
    public Port getPort(int x, int y) {
        int diffX = x - ports[0].getNearX();
        int diffY = y - ports[0].getNearY();
        int minDistance = diffX * diffX + diffY * diffY;
        int near = 0;

        for(int i = 1; i < ports.length; i++) {
            diffX = x - ports[i].getNearX();
            diffY = y - ports[i].getNearY();
            int distance = diffX * diffX + diffY * diffY;
            if(distance < minDistance) {
                minDistance = distance;
                near = i;
            }
        }
        return ports[near];
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
}
