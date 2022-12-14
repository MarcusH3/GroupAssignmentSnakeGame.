package main.java.se.nackademin.GameObject;

import main.java.se.nackademin.GameEngine.GameComponent;
import main.java.se.nackademin.Window.Render;

import java.awt.*;

public class Food extends GameObject{


    private int unitSize = 45;
    private Color colorRGB;
    private int colorValue;
    private MoveState moveState;

    public Food(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition= yPosition;
        this.objectWidth = 45;
        this.objectHeight = 45;
    }
    @Override
    public void update(GameComponent c, float dt) {

    }

    @Override
    public void render(GameComponent c, Render render) {

    }

}
