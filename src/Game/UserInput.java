package Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UserInput implements KeyListener {

    private GameComponent c;
    private final int NUMBER_KEYS = 256;
    private boolean[] keys = new boolean[NUMBER_KEYS];
    private int direction = 0;

    public UserInput(GameComponent c){
        this.c = c;

        c.getWindow().getCanvas().addKeyListener(this);
    }
    public void updateKeyBool(){
        for (int i = 0; i < NUMBER_KEYS; i++) {
            keys[i] = false;
        }
    }
    public boolean isKey(int key){
        return keys[key];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
