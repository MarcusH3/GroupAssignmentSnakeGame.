package Window;

import Game.GameComponent;

import java.awt.*;

public class Render {

    private GameComponent c;

    public Render(GameComponent c) {
    Graphics g = c.getWindow().getCanvas().getGraphics();
    }
    public void draw(Graphics g){
        g.drawOval(0,0,50,50);
        g.setColor(Color.BLACK);
    }
}
