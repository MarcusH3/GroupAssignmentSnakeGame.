
        package se.nackademin.GameObject;

        import se.nackademin.GameEngine.GameComponent;
        import se.nackademin.Geometry.BuffImageMaker;
        import se.nackademin.Geometry.ShapeMaker;
        import se.nackademin.Window.*;
        import se.nackademin.engine.SnackStatus;
        import se.nackademin.engine.SnakeSituation;
        import se.nackademin.engine.SnakeSituationService;
        import se.nackademin.engine.SnakeSituationServiceImpl;

        import java.awt.*;
        import java.awt.event.KeyEvent;
        import java.awt.image.BufferedImage;

        public class Player extends GameObject {


    private int unitSize = 45;
    private int velocity = 0;
    private Color colorRGB;
    private int colorValue;
    private MoveState moveState;
    private SnakeSituationService snakeSituationService;
    private SnakeSituation snakeSituation;
    private SnakeSituationServiceImpl snakeImpl;
    private SnackStatus snackStatus;
    BuffImageMaker buffImageMaker = new BuffImageMaker();
    BufferedImage bufferedImage;

    public Player(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition= yPosition;
        this.objectWidth = 45;
        this.objectHeight = 45;
        moveState = MoveState.STILL;
        snakeSituation = new SnakeSituation();
        snakeImpl = new SnakeSituationServiceImpl();
        snackStatus = SnackStatus.LIVE;
        bufferedImage = buffImageMaker.getBufferedImage(buffImageMaker.getMyPanel());
    }

    @Override
    public void render(GameComponent c, Render r) {
        colorRGB = new Color(Color.GREEN.getRGB());
        colorValue = colorRGB.getRGB();

        for(Point point: snakeSituation.getSnake()){

            r.drawRectangle(point.x*unitSize,point.y*unitSize,unitSize,unitSize,colorValue);

            r.drawBufferedImage(bufferedImage,snakeSituation.getFood().x*unitSize, snakeSituation.getFood().y*unitSize);

        }
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
            case DEAD -> xPosition = xPosition;
        }
        switch (snakeSituation.getStatus()){
            case EAT: {
                c.setSnakeVelocity();
                buffImageMaker = new BuffImageMaker();
                bufferedImage = buffImageMaker.getBufferedImage(buffImageMaker.getMyPanel());
                break;
            }
            case DEAD: moveState = MoveState.DEAD;
            break;
        }
    }
}
