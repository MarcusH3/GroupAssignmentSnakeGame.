package se.nackademin.Geometry;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class BuffImageMaker {

    ImagePanel myPanel;

    public BuffImageMaker() {
        myPanel = new ImagePanel();
        BufferedImage myCreatedBufImage = getBufferedImage(myPanel);
        //showBufferedImage(myCreatedBufImage);
    }

    public BufferedImage getBufferedImage(JPanel panel) {
        BufferedImage buffImage = null;
        buffImage = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImage.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        panel.paint(g);
        g.dispose();

        return buffImage;
    }
    public ImagePanel getMyPanel() {
        return myPanel;
    }
}