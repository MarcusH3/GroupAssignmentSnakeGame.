package Game;

import Window.Window;
import Window.Render;

import java.awt.event.KeyEvent;

public class GameComponent implements Runnable {
    private AbstractGame game;
    private Window window;
    private UserInput userInput;
    private Render render;
    private Thread thread;
    private boolean RUNNING = false;
    private boolean RENDER = false;
    private final double nanoValue = 1000000000.0;
    private final double updatePerSeconds = 1.0 / 60.0;

    public GameComponent(AbstractGame game) {
        this.game = game;
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
        int count = 1;
        double initTime = System.nanoTime() / nanoValue;
        double startTime = 0;
        double timePassed = 0;
        double processedTime = 0;

        while (RUNNING) {
            RENDER = false;
            startTime = System.nanoTime() / nanoValue;
            timePassed = startTime - initTime;
            initTime = startTime;
            processedTime += timePassed;

            while (processedTime >= updatePerSeconds) {
                processedTime -= updatePerSeconds;
                RENDER = true;
                game.update(this, (float) updatePerSeconds);
                userInput.updateKeyBool();
            }
            if (RENDER) {
                render.clearDrawing();
                game.render(this, render);
                window.updateWindow();
            }
        }
    }
    public Render getRender(){
            return render;
    }
    public Window getWindow(){
        return window;
    }

    public UserInput getUserInput() {
        return userInput;
    }
}
