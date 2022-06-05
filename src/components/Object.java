package components;

import java.awt.*;

public class Object extends Shape{
    protected String name;
    public Port[] ports;

    protected Object(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.name = "object";

        //set Port
        ports = new Port[4];
        ports[0] = new Port(x + width / 2 - Port.SIZE / 2, y - Port.SIZE, Port.Position.UP); //up
        ports[1] = new Port(x + width / 2 - Port.SIZE / 2, y + height, Port.Position.DOWN); //down
        ports[2] = new Port(x - Port.SIZE, y + height / 2 - Port.SIZE / 2, Port.Position.LEFT); //left
        ports[3] = new Port(x + width, y + height / 2 - Port.SIZE / 2, Port.Position.RIGHT); //right
    }

    @Override
    public void draw(Graphics2D g) {
        for(Port port : ports) {
            port.draw(g);
        }
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

    @Override
    public void setPosition(int x, int y) {
        int diffX = x - this.x;
        int diffY = y - this.y;
        super.setPosition(x, y);

        for (Port port : ports) {
            port.setPosition(port.x + diffX, port.y + diffY);
        }
    }
}
