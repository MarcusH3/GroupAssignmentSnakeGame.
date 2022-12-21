package se.nackademin.GameEngine;
import se.nackademin.Window.Render;

public interface AbstractGame {
    public abstract void update(GameComponent c, float dt);
    public abstract void render(GameComponent c, Render render);
}
