package Window;

import Game.GameComponent;

import java.awt.*;

public class Render {
    private Canvas canvas;

    public Render(GameComponent c) {

        Graphics g = c.getWindow().getCanvas().getGraphics();
        canvas = c.getWindow().getCanvas();
    }
    public void drawGrid(Graphics g, int noGrids, int width, int height){

        for (int i = 0; i < noGrids; i++) {
            g.setColor(Color.black);
            g.drawLine(i*width/noGrids,0,i*width/noGrids, height);
        }
        for (int i = 0; i < noGrids; i++) {
            g.setColor(Color.black);
            g.drawLine(0,i*height/noGrids,width, i*height/noGrids);
        }
    }
    public void drawRectangle(Graphics g, int xPos, int yPos, int noGrids, int width, int height){

        g.setColor(Color.blue);
        g.fillRect(xPos,yPos,width,height);

    }
    public void clearDrawing(){
        canvas.revalidate();
    }
}
