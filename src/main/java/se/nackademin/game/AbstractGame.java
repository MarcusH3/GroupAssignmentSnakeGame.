package GameEngine;


import Window.Render;

public abstract class AbstractGame {
    public abstract void update(GameComponent gameComponent, float dt);
    public abstract void render(GameComponent c, Render r);
}
