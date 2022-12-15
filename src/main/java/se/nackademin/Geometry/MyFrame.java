package se.nackademin.Geometry;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MyFrame extends JFrame {

// Klassen används endast i testsyfte, kan tas bort när allt är klart!!

    MyPanel myPanel;
    BuffImageMaker buffmaker;
    BufferedImage myCreatedBufImage;

    public MyFrame(){
        buffmaker= new BuffImageMaker();

        this.setPreferredSize(new Dimension(200,200));
        this.setMinimumSize(new Dimension(200,200));
        this.setMaximumSize(new Dimension(200,200));
        this.getContentPane().setBackground(new Color(40,40,40));
        this.setTitle("My Frame");

        this.setLayout(null);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myPanel = new MyPanel();
        myCreatedBufImage = buffmaker.getBufferedImage(new MyPanel());

        this.add(myPanel);
        this.pack();
        this.setLocationRelativeTo(null);

        this.setVisible(true);

        showBufferedImage(myCreatedBufImage);
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
        MyFrame myFrame = new MyFrame();
    }

}
