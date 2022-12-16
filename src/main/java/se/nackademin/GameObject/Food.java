package se.nackademin.GameObject;

import se.nackademin.GameEngine.GameComponent;
import se.nackademin.Window.Render;
import se.nackademin.engine.SnackStatus;
import se.nackademin.engine.SnakeSituation;
import se.nackademin.engine.SnakeSituationService;
import se.nackademin.engine.SnakeSituationServiceImpl;

import java.awt.*;

public class Food extends GameObject{

    private int unitSize = 45;
    private Color colorRGB;
    private int colorValue;
    public Food(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition= yPosition;
        this.objectWidth = 45;
        this.objectHeight = 45;
    }
    @Override
    public void update(GameComponent c, float dt) {

    }

    @Override
    public void render(GameComponent c, Render render) {

    }
}
