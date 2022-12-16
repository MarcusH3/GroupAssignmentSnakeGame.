package se.nackademin.Geometry;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ShapesEllips implements Shapes {

    Colors colors;

    public ShapesEllips(){
        colors = new Colors();
    }
    public void drawShape(Graphics g,int x,int y,int w, int h ) {
        Graphics2D g2d = (Graphics2D)g;



        g2d.setStroke(new BasicStroke(3));

            Ellipse2D.Double e = new Ellipse2D.Double(x, y, w, h);
            Ellipse2D.Double e1 = new Ellipse2D.Double(x+(w/12.0), y+(h/12.0), w/1.2, h/1.2);
            Ellipse2D.Double e2 = new Ellipse2D.Double(x+(w/8.0), y+(h/8.0), w/2.5, h/2.5);

            g2d.setColor(colors.getDarkColor());
            g2d.fill(e);

            g2d.setColor(colors.getMidColor());
            g2d.fill(e1);

            g2d.setColor(colors.getLightColor());
            g2d.fill(e2);

    }
}
