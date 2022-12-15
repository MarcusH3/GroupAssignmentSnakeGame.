package se.nackademin.GameObject;
import se.nackademin.GameEngine.GameComponent;
import se.nackademin.Window.*;

public class Board extends GameObject {

    private int boardWidth;
    private int boardHeight;
    public Board(GameComponent c, int boardWidth, int boardHeight) {
        this.boardWidth = c.getWindow().getUpdatedWidth();
        this.boardHeight = c.getWindow().getUpdatedHeight();
    }

    @Override
    public void update(GameComponent c, float dt) {

    }

    @Override
    public void render(GameComponent c, Render render) {
    }
}
