package se.nackademin.GameObject;

import se.nackademin.GameEngine.GameComponent;
import se.nackademin.Window.Render;

public abstract class GameObject {
    protected int xPosition;
    protected int yPosition;

    public abstract void update(GameComponent c, float dt);
    public abstract void render(GameComponent c, Render render);
}
