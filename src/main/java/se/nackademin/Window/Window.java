package main.java.se.nackademin.Window;

import main.java.se.nackademin.GameEngine.GameComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Window {
    private JFrame frame;
    private Canvas canvas;
    private Graphics g;
    private BufferedImage bufferedImage;
    private BufferStrategy bufferStrategy;

    private static final int width = 240;
    private static final int height = 240;
    private static final int scalar = 3;

    private Dimension dimension = new Dimension(width*scalar,height*scalar);

    public Window(GameComponent c){
        bufferedImage = new BufferedImage(dimension.width,dimension.height, BufferedImage.TYPE_INT_RGB);


        canvas = new Canvas();
        canvas.setPreferredSize(dimension);
        canvas.setMaximumSize(dimension);
        canvas.setMinimumSize(dimension);

        frame = new JFrame("GameEngine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas);
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        canvas.createBufferStrategy(3);
        bufferStrategy = canvas.getBufferStrategy();
        g = bufferStrategy.getDrawGraphics();
    }
    public void updateWindow(){
        g.drawImage(bufferedImage,0,0, canvas.getWidth(),canvas.getHeight(), null);
        bufferStrategy.show();
    }
    public BufferedImage getBufferedImage(){
        return bufferedImage;
    }
    public Canvas getCanvas(){
        return canvas;
    }

    public int getUpdatedWidth() {
        return dimension.width;
    }

    public int getUpdatedHeight() {
        return dimension.height;
    }
}
