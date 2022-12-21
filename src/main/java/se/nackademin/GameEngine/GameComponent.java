package se.nackademin.GameEngine;
import se.nackademin.Window.Window;
import se.nackademin.Window.Render;

public class GameComponent implements Runnable {
    private final AbstractGame game;
    private Window window;
    private UserInput userInput;
    private Render render;
    private Thread thread;
    private boolean RUNNING = false;
    private boolean RENDER = false;
    private final double nanoValue = 1000000000.0;
    private double updatePerSeconds = 1.0 / 5.0;
    private GameState gameState = GameState.TITLE_SCREEN;

    private static GameComponent gameComponent = null;

    private  GameComponent(AbstractGame game){
        this.game = game;
        startGame();
    }
    public static GameComponent getInstance(AbstractGame game){
        if(gameComponent == null){
            gameComponent = new GameComponent(game);
        }
        return gameComponent;
    }

    public synchronized void startGame() {
        if (RUNNING) {
            return;
        }
        RUNNING = true;
        window = new Window(this);
        userInput = new UserInput(this);
        render = new Render(this);
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        double initTime = System.nanoTime() / nanoValue;
        double startTime;
        double timePassed;
        double processedTime = 0;

        while (RUNNING) {
            RENDER = true;
            startTime = System.nanoTime() / nanoValue;
            timePassed = startTime - initTime;
            initTime = startTime;
            processedTime += timePassed;

            while (processedTime >= updatePerSeconds) {
                processedTime -= updatePerSeconds;
                RENDER = true;
                game.update(this, (float) updatePerSeconds);
                //userInput.updateKeyBool();
            }
            if (RENDER) {
                window.updateWindow();
                render.clearDrawing();
                game.render(this, render);
            }
        }
    }
    public Window getWindow(){
        return window;
    }

    public UserInput getUserInput() {
        return userInput;
    }

    public double setSnakeVelocity() {
        return this.updatePerSeconds *=  0.95;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}

