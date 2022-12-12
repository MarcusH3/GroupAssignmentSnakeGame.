package Game;

import Window.Window;

public class GameComponent implements Runnable{
    private AbstractGame game;
    private Window window;
    private UserInput userInput;
    private Thread thread;
    private boolean RUNNING = false;

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
                    //render = true;
                    game.update(this, (float) updatePerSeconds);
                    System.out.println(count);
                    count++;
                }
            }
        }

        public void render(){}
        public void update(){}
    public Window getWindow(){
            return window;
    }
    }
