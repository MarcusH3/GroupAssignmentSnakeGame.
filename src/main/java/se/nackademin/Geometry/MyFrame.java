package se.nackademin.Geometry;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    MyPanel myPanel;
    BuffImageMaker buffmaker;

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
        buffmaker.getBufferedImage(new MyPanel());


        this.add(myPanel);
        this.pack();
        this.setLocationRelativeTo(null);

        this.setVisible(true);



    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
    }

}
