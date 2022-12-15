
        package se.nackademin.GameObject;

        import se.nackademin.GameEngine.GameComponent;
        import se.nackademin.Window.*;
        import se.nackademin.engine.SnakeSituation;
        import se.nackademin.engine.SnakeSituationService;
        import se.nackademin.engine.SnakeSituationServiceImpl;

        import java.awt.*;
        import java.awt.event.KeyEvent;

public class Player extends GameObject {


    private int unitSize = 45;
    private int velocity = 0;
    private Color colorRGB;
    private int colorValue;
    private MoveState moveState;
    private SnakeSituationService snakeSituationService;
    private SnakeSituation snakeSituation;
    private SnakeSituationServiceImpl snakeImpl;

    public Player(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition= yPosition;
        this.objectWidth = 45;
        this.objectHeight = 45;
        moveState = MoveState.STILL;
        snakeSituation = new SnakeSituation();
        snakeImpl = new SnakeSituationServiceImpl();
    }

    @Override
    public void render(GameComponent c, Render r) {
        colorRGB = new Color(Color.GREEN.getRGB());
        colorValue = colorRGB.getRGB();

        for(Point point: snakeSituation.getSnake()){
            r.drawRectangle(point.x*unitSize,point.y*unitSize,unitSize,unitSize,colorValue);
        }
        colorRGB = new Color(Color.RED.getRGB());
        colorValue = colorRGB.getRGB();

            r.drawRectangle(snakeSituation.getFood().x*unitSize,snakeSituation.getFood().y*unitSize,unitSize,unitSize,colorValue);


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

            case UP -> snakeImpl.moveUp(snakeSituation);
            case DOWN -> snakeImpl.moveDown(snakeSituation);
            case LEFT -> snakeImpl.moveLeft(snakeSituation);
            case RIGHT -> snakeImpl.moveRight(snakeSituation);
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
