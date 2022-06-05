package components;

import java.awt.*;

public class Composition extends Line{
    public Composition(Port from, Port to) {
        super(from, to);
    }

    @Override
    protected void drawArrow(Graphics2D g, int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;

        double D = Math.sqrt(dx * dx + dy * dy);

        double arrowLeftX = D - 10;
        double arrowRightX = arrowLeftX;
        double arrowLeftY = 10;
        double arrowRightY = -10;
        double x;

        double sin = dy / D;
        double cos = dx / D;

        x = arrowLeftX * cos - arrowLeftY * sin + x1;
        arrowLeftY = arrowLeftX * sin + arrowLeftY * cos + y1;
        arrowLeftX = x;

        x = arrowRightX * cos - arrowRightY * sin + x1;
        arrowRightY = arrowRightX * sin + arrowRightY * cos + y1;
        arrowRightX = x;

        double arrowBackX = arrowLeftX + (arrowRightX - x2);
        double arrowBackY = arrowLeftY + (arrowRightY - y2);

        int[] xPoints = {x2, (int)arrowLeftX, (int)arrowBackX, (int)arrowRightX};
        int[] yPoints = {y2, (int)arrowLeftY, (int)arrowBackY, (int)arrowRightY};


        g.setColor(Color.white);
        g.fillPolygon(xPoints, yPoints, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, 4);
    }
}
