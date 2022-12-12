package Window;

import Game.GameComponent;

import javax.swing.*;
import java.awt.*;

public class Window {
    private JFrame frame;
    private Canvas canvas;
    private Graphics g;

    private static final int width = 240;
    private static final int height = 240;
    private static final int scalar = 3;

    private Dimension dimension = new Dimension(width*scalar,height*scalar);

    public Window(GameComponent c){

        canvas = new Canvas();
        canvas.setPreferredSize(dimension);
        canvas.setMaximumSize(dimension);
        canvas.setMinimumSize(dimension);

        frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas);
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        g = canvas.getGraphics();
    }
    public void updateWindow(){
    }
    public Canvas getCanvas(){
        return canvas;
    }
}
