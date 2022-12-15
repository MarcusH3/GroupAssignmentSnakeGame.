package main.java.se.nackademin.Geometry;

import java.awt.*;
import java.awt.geom.Path2D;

public class ShapesDiamond implements Shapes {

    Colors colors;

    public ShapesDiamond(){
        colors = new Colors();
    }
    public void drawShape(Graphics g, int x, int y, int w, int h) {
        Graphics2D g2d = (Graphics2D)g;

        g2d.setStroke(new BasicStroke(3));



        Path2D.Double p = new Path2D.Double();
        for (int i = 0; i <2 ; i++) {
            p.moveTo(x + (w / 2), y);
            p.lineTo(x + w, y + (h / 2));
            p.lineTo(x + (w / 2), y + h);
            p.lineTo(x, y + h / 2);
            p.closePath();
            g2d.setColor(colors.getMidColor());
            if (i == 0) {
                g2d.fill(p);
            }
            else {
                g2d.setColor(colors.getDarkColor());
                g2d.draw(p);
            }

        }





    }

}
