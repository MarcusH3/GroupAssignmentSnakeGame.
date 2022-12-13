package se.nackademin.game;

import se.nackademin.Window.Window;
import se.nackademin.Window.Render;

import java.awt.event.KeyEvent;

public class GameComponent implements Runnable{
    private AbstractGame game;
    private Window window;
    private UserInput userInput;
    private Render render;
    private Thread thread;
    private boolean RUNNING = false;
    private boolean RENDER = false;
    private final double nanoValue = 1000000000.0;
    private final double updatePerSeconds = 1.0/60.0;
    private int numberOfGrids = 16;
    private int direction = 2;
    private int xPosition;
    private int yPosition;


        public GameComponent(AbstractGame game) {
            this.game = game;
        }

        public synchronized void startGame(){
            if(RUNNING){
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
            double initTime = System.nanoTime()/nanoValue;
            double startTime = 0;
            double timePassed = 0;
            double processedTime = 0;

            while(RUNNING) {
                RENDER = false;
                startTime = System.nanoTime() / nanoValue;
                timePassed = startTime - initTime;
                initTime = startTime;
                processedTime += timePassed;

                while (processedTime >= updatePerSeconds) {
                    processedTime -= updatePerSeconds;
                    RENDER = true;

                    if (userInput.isKey(KeyEvent.VK_UP)) {
                        direction = 0;
                        System.out.println("up");
                    }
                    if (userInput.isKey(KeyEvent.VK_DOWN)) {
                        direction = 1;
                        System.out.println("down");
                    }
                    if (userInput.isKey(KeyEvent.VK_LEFT)) {
                        direction = 2;
                        System.out.println("left");
                    }
                    if (userInput.isKey(KeyEvent.VK_RIGHT)) {
                        direction = 3;
                        System.out.println("right");
                    }
                    switch (direction) {
                        case 0 -> yPosition -= window.getUpdatedHeight() / numberOfGrids;
                        case 1 -> yPosition += window.getUpdatedHeight() / numberOfGrids;
                        case 2 -> xPosition -= window.getUpdatedWidth() / numberOfGrids;
                        case 3 -> xPosition += window.getUpdatedWidth() / numberOfGrids;
                    }
                    userInput.updateKeyBool();
                }
                    if(RENDER) {
                       render.drawGrid(window.getCanvas().getGraphics(), numberOfGrids, window.getUpdatedWidth(), window.getUpdatedHeight());
                        render.drawRectangle(window.getCanvas().getGraphics(),xPosition,yPosition,numberOfGrids, window.getUpdatedWidth(), window.getUpdatedHeight());
                    }
                    else{
                        try {
                            Thread.sleep(1);
                        }
                        catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    //game.update(this, (float) updatePerSeconds);


                }

            }
        public Render getRender(){
            return render;
        }
        public Window getWindow(){
            return window;
        }
}
