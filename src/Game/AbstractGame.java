package Game;


public abstract class AbstractGame {
    public abstract void update(GameComponent gameComponent, float dt);
    public abstract void render();
}
