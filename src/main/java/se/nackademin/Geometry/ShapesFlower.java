package se.nackademin.Geometry;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ShapesFlower implements Shapes {

    Colors colors;

    public ShapesFlower(){
        colors = new Colors();
    }

    public void drawShape(Graphics g, int x, int y, int w, int h) {
        Graphics2D g2d = (Graphics2D)g;

        g2d.setStroke(new BasicStroke(2));

            Ellipse2D.Double e = new Ellipse2D.Double(x, y, w, h);
            Ellipse2D.Double e2 = new Ellipse2D.Double(x+(w/3.0), y, w/3.0, h);
            Ellipse2D.Double e3 = new Ellipse2D.Double(x, y+(h/3.0), w, h/3.0);
            g2d.setColor(colors.getDarkColor());
            g2d.fill(e);
            g2d.setColor(colors.getMidColor());
            g2d.fill(e2);
            g2d.setColor(colors.getLightColor());
            g2d.fill(e3);

    }

}
