package se.nackademin.MenuObject;

import se.nackademin.GameEngine.GameComponent;
import se.nackademin.Window.Render;

public abstract class MenuObject {
    public abstract void update(GameComponent c, float dt);
    public abstract void render(GameComponent c, Render r);

}
