package main.java.se.nackademin.Geometry;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class ShapesRectangle implements Shapes {

    Colors colors;

    public ShapesRectangle() {

        colors = new Colors();
    }

    public void drawShape(Graphics g,int x, int y, int w, int h) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(4));

        Rectangle2D.Double e = new Rectangle2D.Double(x, y, w, h);
        g2d.setColor(colors.getMidColor());
        g2d.fill(e);
        g2d.setColor(colors.getDarkColor());
        g2d.draw(e);

    }
}
