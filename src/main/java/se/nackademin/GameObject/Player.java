
        package main.java.se.nackademin.GameObject;

        import main.java.se.nackademin.GameEngine.GameComponent;
        import main.java.se.nackademin.Window.*;
        import java.awt.*;
        import java.awt.event.KeyEvent;

public class Player extends GameObject {


    private int unitSize = 45;
    private int velocity = 0;
    private Color colorRGB;
    private int colorValue;
    private MoveState moveState;

    public Player(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition= yPosition;
        this.objectWidth = 45;
        this.objectHeight = 45;
        moveState = MoveState.STILL;
    }

    @Override
    public void render(GameComponent c, Render r) {
        colorRGB = new Color(Color.GREEN.getRGB());
        colorValue = colorRGB.getRGB();
        r.drawRectangle(xPosition,yPosition,unitSize,unitSize,colorValue);
    }

    @Override
    public void update(GameComponent c, float dt) {

        if (c.getUserInput().isKey(KeyEvent.VK_UP)) {
            moveState = MoveState.UP;
        }
        if (c.getUserInput().isKey(KeyEvent.VK_DOWN)) {
            moveState = MoveState.DOWN;
        }
        if (c.getUserInput().isKey(KeyEvent.VK_LEFT)) {
            moveState = MoveState.LEFT;
        }
        if (c.getUserInput().isKey(KeyEvent.VK_RIGHT)) {
            moveState = MoveState.RIGHT;
        }
        switch (moveState) {
            case UP -> yPosition -= 45;
            case DOWN -> yPosition += 45;
            case LEFT -> xPosition -= 45;
            case RIGHT -> xPosition += 45;
            case STILL -> xPosition = xPosition;
        }
        if(xPosition<0){
            xPosition = 0;
            moveState = MoveState.STILL;
        }
        if(xPosition == c.getWindow().getCanvas().getWidth()){
            xPosition = c.getWindow().getCanvas().getWidth()-45;
            moveState = MoveState.STILL;
        }
        if(yPosition<0){
            yPosition = 0;
            moveState = MoveState.STILL;
        }
        if (yPosition == c.getWindow().getCanvas().getHeight()){
            yPosition = c.getWindow().getCanvas().getHeight()-45;
            moveState = MoveState.STILL;
        }
    }
}
