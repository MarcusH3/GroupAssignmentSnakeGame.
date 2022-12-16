package se.nackademin.Geometry;

import java.awt.*;
import java.awt.geom.Path2D;

public class ShapesDiamond implements Shapes {

    Colors colors;

    public ShapesDiamond() {
        colors = new Colors();
    }

    public void drawShape(Graphics g, int x, int y, int w, int h) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(4));

        Path2D.Double p = new Path2D.Double();
        Path2D.Double p2 = new Path2D.Double();
        Path2D.Double p3 = new Path2D.Double();


        p.moveTo(x + (w / 2.0), y);
        p.lineTo(x + w, y + (h / 2.0));
        p.lineTo(x + (w / 2.0), y + h);
        p.closePath();

        p2.moveTo(x + (w / 2.0), y);
        p2.lineTo(x, y + h / 2.0);
        p2.lineTo(x + (w / 2.0), y + h);
        p2.closePath();

        p3.moveTo(x + (w / 2.0), y);
        p3.lineTo(x, y + h / 2.0);
        p3.lineTo(x + (w / 2.0), y + h);

        g2d.setColor(colors.getDarkColor());
        g2d.fill(p);
        g2d.setColor(colors.getMidColor());
        g2d.fill(p2);
        g2d.setColor(colors.getLightColor());
        g2d.draw(p3);

    }
}
