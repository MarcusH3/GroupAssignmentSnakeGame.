package GameObject;

import Game.GameComponent;
import Window.Render;

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

    }
}

