package Game;

import Window.Window;

public class GameComponent implements Runnable{
    private AbstractGame game;
    private Window window;
    private Thread thread;
    private boolean RUNNING = false;


        public GameComponent(AbstractGame game) {
            this.game = game;
        }

        public synchronized void startGame(){
            if(RUNNING){
                return;
            }
            RUNNING = true;
            window = new Window();
            thread = new Thread(this);
            thread.start();
        }
        @Override
        public void run() {

        }
        public void render(){}
        public void update(){}
    }
