package GameObject;

import Game.GameComponent;
import Window.Render;

public class Board extends GameObject{

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
        render.drawRectangle(c.getWindow().getCanvas().getGraphics(), 0,0,16,boardWidth,boardHeight);
        render.drawGrid(c.getWindow().getCanvas().getGraphics(), 16,boardWidth,boardHeight);
    }
}
