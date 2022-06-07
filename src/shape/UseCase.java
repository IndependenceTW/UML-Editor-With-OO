package shape;

import java.awt.*;

public class UseCase extends Object{
    public UseCase(int x, int y) {
        super(x, y, 100, 80);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillOval(x1, y1, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        g.drawOval(x1, y1, WIDTH, HEIGHT);

        if(isSelected) {
            drawPorts(g);
        }
    }
}
