package se.nackademin.Geometry;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class BuffImageMaker {


    MyPanel myPanel;
    public BuffImageMaker(){
        myPanel = new MyPanel();
        BufferedImage myCreatedBufImage = getBufferedImage(myPanel);
        showBufferedImage(myCreatedBufImage);
    }

    public BufferedImage getBufferedImage(JPanel panel){
        BufferedImage buffImage = null;
        buffImage = new BufferedImage(panel.getWidth(),panel.getHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImage.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        panel.paint(g);
        g.dispose();

        System.out.println(buffImage);
        return buffImage;
    }

    public void showBufferedImage(BufferedImage bim){
        JFrame showframe = new JFrame();
        showframe.setPreferredSize(new Dimension(200,200));
        showframe.setMinimumSize(new Dimension(200,200));
        showframe.setMaximumSize(new Dimension(200,200));
        showframe.getContentPane().setBackground(Color.white);
        JLabel myLabel = new JLabel(new ImageIcon(bim));
        myLabel.setBounds(10,10,100,100);
        showframe.add(myLabel);

        showframe.setLayout(null);
        showframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        showframe.pack();
        showframe.setVisible(true);

    }

    public static void main(String[] args) {
        BuffImageMaker bf = new BuffImageMaker();
    }


}
