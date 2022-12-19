package se.nackademin.GameObject;

import se.nackademin.GameEngine.GameComponent;
import se.nackademin.Window.Render;

public abstract class GameObject {
    protected int xPosition;
    protected int yPosition;
    protected int objectWidth;
    protected int objectHeight;

    public abstract void update(GameComponent c, float dt);
    public abstract void render(GameComponent c, Render render);

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getObjectWidth() {
        return objectWidth;
    }

    public void setObjectWidth(int objectWidth) {
        this.objectWidth = objectWidth;
    }

    public int getObjectHeight() {
        return objectHeight;
    }

    public void setObjectHeight(int objectHeight) {
        this.objectHeight = objectHeight;
    }
}
