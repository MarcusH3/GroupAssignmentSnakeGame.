package se.nackademin.Geometry;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class ShapesRectangle implements Shapes {

    Colors colors;

    public ShapesRectangle() {

        colors = new Colors();
    }

    public void drawShape(Graphics g,int x, int y, int w, int h) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(5));

        Rectangle2D.Double e = new Rectangle2D.Double(x, y, w, h);
        Rectangle2D.Double e1 = new Rectangle2D.Double(x+(w/2.0), y, w/2.0, h/2.0);
        Rectangle2D.Double e2 = new Rectangle2D.Double(x, y+(h/2.0), w/2.0, h/2.0);

        g2d.setColor(colors.getMidColor());
        g2d.fill(e);

        g2d.setColor(colors.getLightColor());
        g2d.fill(e1);
        g2d.fill(e2);

        g2d.setColor(colors.getDarkColor());
        g2d.draw(e);

    }
}
