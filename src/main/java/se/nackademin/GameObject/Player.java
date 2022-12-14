package main.java.se.nackademin.GameObject;

import main.java.se.nackademin.GameEngine.GameComponent;
import main.java.se.nackademin.Window.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends GameObject {


    private int unitSize = 45;
    private int velocity = 1;
    private Color colorRGB;
    private int colorValue;
    private MoveState moveState;

    public Player(int xPosition, int yPosition) {
        this.xPosition = xPosition*45;
        this.yPosition= yPosition*45;
        this.objectWidth = 45;
        this.objectHeight = 45;
        moveState = MoveState.DOWN;
    }

   /* @Override
    public void render(GameComponent c, Render r) {
        colorRGB = new Color(Color.GREEN.getRGB());
        colorValue = colorRGB.getRGB();
        r.drawRectangle(xPosition,yPosition,45,45,colorValue);
    }*/


    @Override
    public void render(GameComponent c, Render r) {
        colorRGB = new Color(Color.GREEN.getRGB());
        colorValue = colorRGB.getRGB();
        r.drawRectangle(xPosition,yPosition,45,45,colorValue);
    }


    @Override
    public void update(GameComponent c, float dt) {
        if (c.getUserInput().isKey(KeyEvent.VK_UP)) {
            moveState = MoveState.UP;
        }
        if (c.getUserInput().isKey(KeyEvent.VK_DOWN)) {
            moveState = MoveState.DOWN;
        }
        if(c.getUserInput().isKey(KeyEvent.VK_LEFT)) {
            moveState = MoveState.LEFT;
        }
        if (c.getUserInput().isKey(KeyEvent.VK_RIGHT)) {
            moveState = MoveState.RIGHT;
        }
        switch (moveState){
            case UP -> yPosition -= 45;
            case DOWN -> yPosition += 45;
            case LEFT -> xPosition -= 45;
            case RIGHT -> xPosition += 45;
            case STILL -> xPosition = xPosition;
        }
    }
}

