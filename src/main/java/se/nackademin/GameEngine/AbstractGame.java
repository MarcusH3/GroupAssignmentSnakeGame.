package main.java.se.nackademin.GameEngine;
import main.java.se.nackademin.Window.Render;

public abstract class AbstractGame {
    public abstract void update(GameComponent c, float dt);
    public abstract void render(GameComponent c, Render render);
}
