package se.nackademin.Geometry;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class MyPanel extends JPanel {
    int panelWidth = 45;
    int panelHeight = 45;
    ShapeMaker shapeMaker;



    public MyPanel() {
        this.setBackground(Color.gray);
        this.setBounds(10, 10, panelWidth, panelHeight);
        shapeMaker = new ShapeMaker();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Color bgcolor = this.getBackground();
        g2d.setColor(bgcolor);
        Rectangle2D.Double r = new Rectangle2D.Double(0, 0, panelWidth, panelHeight);
        g2d.fill(r);

        shapeMaker.myshapes.drawShape(g2d, 0, 0, panelWidth, panelHeight);

    }



}
