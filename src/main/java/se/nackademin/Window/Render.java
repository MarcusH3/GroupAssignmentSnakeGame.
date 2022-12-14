package main.java.se.nackademin.Window;

import main.java.se.nackademin.GameEngine.GameComponent;

import java.awt.*;
import java.awt.image.DataBufferInt;

public class Render {
    private Canvas canvas;
    private int pixelWidth = 45;
    private int pixelHeight = 45;
    private int[] pixel;

    public Render(GameComponent c) {

        Graphics g = c.getWindow().getCanvas().getGraphics();
        canvas = c.getWindow().getCanvas();
        pixel = ((DataBufferInt)c.getWindow().getBufferedImage().getRaster().getDataBuffer()).getData();
    }

    public void paintPixel(int xPosition, int yPosition, int colorValue){
        if(xPosition < 0 || xPosition > canvas.getWidth() || yPosition < 0 || yPosition > canvas.getHeight()){
            return;
        }
        pixel[xPosition + yPosition * pixelWidth] = colorValue;
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
    public void drawRectangle(int xPosition, int yPosition, int width, int height, int colorValue){

        if(xPosition < 0 || xPosition > canvas.getWidth() || yPosition < 0 || yPosition > canvas.getHeight()){
            return;
        }
        else {
            for(int i = 0; i < width; i++) {
                for(int j = 0; j < height; j++) {
                    paintPixel((xPosition +i),(yPosition+j),colorValue);
                }
            }
        }
        System.out.println("");

    }
    public void clearDrawing(){
        for (int i = 0; i < pixel.length; i++) {
            pixel[i] = 0;
        }
    }
}
