package Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UserInput implements KeyListener {

    private GameComponent c;
    public UserInput(GameComponent c){
        this.c = c;

        c.getWindow().getCanvas().addKeyListener(this);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyCode()){
            case 37 -> System.out.println("up");
            case 39 -> System.out.println("down");
            case 38 -> System.out.println("left");
            case 40 -> System.out.println("right");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
