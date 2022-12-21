
        package se.nackademin.GameObject;

        import se.nackademin.GameEngine.GameComponent;
        import se.nackademin.GameEngine.GameState;
        import se.nackademin.Geometry.BuffImageMaker;
        import se.nackademin.Window.*;
        import se.nackademin.engine.SnackStatus;
        import se.nackademin.engine.SnakeSituation;
        import se.nackademin.engine.SnakeSituationServiceImpl;

        import java.awt.*;
        import java.awt.event.KeyEvent;
        import java.awt.image.BufferedImage;

        public class Player extends GameObject {
    private static final int unitSize = 45;
            private MoveState moveState;
    private final SnakeSituation snakeSituation;
    private final SnakeSituationServiceImpl snakeImpl;
    private SnackStatus snackStatus;
            BuffImageMaker buffImageMaker = new BuffImageMaker();
            private Sound sound = new Sound();
            private final Sound eatSound = new Sound();
            private final Sound gameOverSound = new Sound();
    BufferedImage bufferedImage;

    public Player(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition= yPosition;
        this.objectWidth = 45;
        this.objectHeight = 45;
        moveState = MoveState.STILL;
        snakeSituation = new SnakeSituation();
        snakeImpl = new SnakeSituationServiceImpl();
        bufferedImage = buffImageMaker.getBufferedImage(buffImageMaker.getMyPanel());
        playMusic(1);
    }
    @Override
    public void render(GameComponent c, Render r) {
        Color colorRGB = new Color(Color.GREEN.getRGB());
        int colorValue = colorRGB.getRGB();

        for (Point point : snakeSituation.getSnake()) {

            r.drawRectangle(point.x * unitSize, point.y * unitSize, unitSize, unitSize, colorValue);

            r.drawBufferedImage(bufferedImage, snakeSituation.getFood().x * unitSize, snakeSituation.getFood().y * unitSize);
        }
    }
    @Override
    public void update(GameComponent c, float dt) {

        if (c.getUserInput().isKey(KeyEvent.VK_UP)) {
            if(moveState == MoveState.DOWN) {
                snackStatus = SnackStatus.DEAD;
                snakeSituation.setStatus(snackStatus);
            }
            moveState = MoveState.UP;
            }

        if (c.getUserInput().isKey(KeyEvent.VK_DOWN)) {
            if(moveState == MoveState.UP) {
                snackStatus = SnackStatus.DEAD;
                snakeSituation.setStatus(snackStatus);
            }
            moveState = MoveState.DOWN;
        }
        if (c.getUserInput().isKey(KeyEvent.VK_LEFT)) {
            if(moveState == MoveState.RIGHT) {
                snackStatus = SnackStatus.DEAD;
                snakeSituation.setStatus(snackStatus);
            }
            moveState = MoveState.LEFT;
        }
        if (c.getUserInput().isKey(KeyEvent.VK_RIGHT)) {
            if(moveState == MoveState.LEFT) {
                snackStatus = SnackStatus.DEAD;
                snakeSituation.setStatus(snackStatus);
            }
            moveState = MoveState.RIGHT;
        }
        if(snackStatus != SnackStatus.DEAD) {
            switch (moveState) {
                case UP -> snakeImpl.moveUp(snakeSituation);
                case DOWN -> snakeImpl.moveDown(snakeSituation);
                case LEFT -> snakeImpl.moveLeft(snakeSituation);
                case RIGHT -> snakeImpl.moveRight(snakeSituation);
                case STILL -> xPosition = xPosition;
                case DEAD -> xPosition = xPosition;
            }
        }
        switch (snakeSituation.getStatus()) {
            case EAT -> {
                playEatSound(0);
                c.setSnakeVelocity();
                buffImageMaker = new BuffImageMaker();
                bufferedImage = buffImageMaker.getBufferedImage(buffImageMaker.getMyPanel());
            }
            case DEAD -> {
                c.setGameState(GameState.GAME_OVER);
                sound.stop();
                playGameOverSound(2);
            }
            }
        }
            public void playMusic(int i) {
                sound.setFile(i);
                sound.play();
                sound.loop();
            }
            public void stopMusic(){sound.stop();
            }
            public void playEatSound(int i){
                eatSound.setFile(i);
                eatSound.play();
            }

            public void playGameOverSound(int i){
            gameOverSound.setFile(i);
            gameOverSound.play();

    }
}
