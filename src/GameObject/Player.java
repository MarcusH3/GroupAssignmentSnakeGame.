package GameObject;

import Game.GameComponent;
import Game.UserInput;
import Window.Render;

import java.awt.event.KeyEvent;

public class Player extends GameObject{

    private int unitSize = 45;

    public Player(int xPosition, int yPosition) {
        this.xPosition = xPosition*45;
        this.yPosition= yPosition*45;
        this.objectWidth = 45;
        this.objectHeight = 45;
    }

    @Override
    public void render(GameComponent c, Render r) {
        r.drawRectangle(c.getWindow().getCanvas().getGraphics(), xPosition,yPosition,16,45,45);
    }

    @Override
    public void update(GameComponent c, float dt) {
        if (c.getUserInput().isKey(KeyEvent.VK_UP)) {
            if(yPosition != 0) {
                yPosition -= 45;
            }
            else return;
            System.out.println(yPosition);
        }
        if (c.getUserInput().isKey(KeyEvent.VK_DOWN)) {
            if(yPosition != c.getWindow().getUpdatedHeight()) {
                yPosition += 45;
            }
            else return;
            System.out.println(yPosition);
        }
        if(c.getUserInput().isKey(KeyEvent.VK_LEFT)) {
            if(xPosition != 0) {
                xPosition -= 45;
            }
            else return;
            System.out.println(xPosition);
        }
        if (c.getUserInput().isKey(KeyEvent.VK_RIGHT)) {
            if(xPosition != c.getWindow().getUpdatedWidth()) {
                xPosition += 45;
            }
            else return;
            System.out.println(xPosition);
        }
    }
}

