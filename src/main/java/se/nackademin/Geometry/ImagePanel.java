package se.nackademin.Geometry;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class ImagePanel extends JPanel {
    int panelWidth = 45;
    int panelHeight = 45;
    ShapeMaker shapeMaker;

    public ImagePanel() {
        this.setBounds(10, 10, panelWidth, panelHeight);
        this.setBackground(Color.black);
        shapeMaker = new ShapeMaker();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        Color bgcolor = this.getBackground();
        g2d.setColor(bgcolor);
        Rectangle2D.Double r = new Rectangle2D.Double(0, 0, panelWidth, panelHeight);
        g2d.fill(r);

        shapeMaker.myshapes.drawShape(g2d, 0, 0, panelWidth, panelHeight);

    }




}
