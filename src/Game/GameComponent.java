package Game;

import Window.Window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameComponent implements Runnable{
    private AbstractGame game;
    private Window window;
    private UserInput userInput;
    private Thread thread;
    private boolean RUNNING = false;
    private boolean RENDER = false;
    private final double nanoValue = 1000000000.0;
    private final double updatePerSeconds = 1.0/60.0;


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
                startTime = System.nanoTime() / nanoValue;
                timePassed = startTime - initTime;
                initTime = startTime;
                processedTime += timePassed;

                while (processedTime >= updatePerSeconds) {
                    processedTime -= updatePerSeconds;
                    RENDER = true;

                    if(userInput.isKey(KeyEvent.VK_UP)){
                        System.out.println("up");
                    }
                    if(userInput.isKey(KeyEvent.VK_DOWN)){
                        System.out.println("down");
                    }
                    if(userInput.isKey(KeyEvent.VK_LEFT)){
                        System.out.println("left");
                    }
                    if(userInput.isKey(KeyEvent.VK_RIGHT)){
                        System.out.println("right");
                    }
                    //game.update(this, (float) updatePerSeconds);
                    userInput.updateKeyBool();
                }
            }
        }

        public void render(){}
        public void update(){}
    public Window getWindow(){
            return window;
    }
    }
