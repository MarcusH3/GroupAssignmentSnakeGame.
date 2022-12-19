package se.nackademin.Window;

import se.nackademin.GameEngine.GameComponent;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

public class Render {
    private Canvas canvas;
    private int[] pixel;
    private int[] imagePixel;

    public Render(GameComponent c) {

        Graphics g = c.getWindow().getCanvas().getGraphics();
        canvas = c.getWindow().getCanvas();
        pixel = ((DataBufferInt)c.getWindow().getBufferedImage().getRaster().getDataBuffer()).getData();
    }

    public void paintPixel(int xPosition, int yPosition, int colorValue){
        if(xPosition < 0 || xPosition > canvas.getWidth() || yPosition < 0 || yPosition > canvas.getHeight()){
            return;
        }
        pixel[xPosition + yPosition*canvas.getWidth()] = colorValue;
    }
    public void drawRectangle(int xPosition, int yPosition, int width, int height, int colorValue){

        if(xPosition < 0 || xPosition > canvas.getWidth() || yPosition < 0 || yPosition > canvas.getHeight()-height){

        }
        else {
            for(int i = 0; i < width; i++) {
                for(int j = 0; j < height; j++) {
                    paintPixel((xPosition +i),(yPosition+j),colorValue);
                }
            }
        }
    }
    public void drawBufferedImage(BufferedImage bufferedImage, int xPosition, int yPosition){
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        imagePixel = bufferedImage.getRGB(0,0,width,height,null,0,width);
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                paintPixel((xPosition +j),(yPosition+i),imagePixel[j +i*width]);
            }
        }
    }
    public void clearDrawing(){
        Arrays.fill(pixel, 0);
    }
}