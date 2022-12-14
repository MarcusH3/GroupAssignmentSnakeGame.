package main.java.se.nackademin.GameEngine;
import main.java.se.nackademin.GameObject.GameObject;
import main.java.se.nackademin.Window.Render;
import main.java.se.nackademin.GameObject.Player;
import java.util.ArrayList;
import java.util.List;


public class GameManager extends AbstractGame{

    private List<GameObject> gameObjects = new ArrayList<>();

    public GameManager() {


        Player player = new Player(320,320);
        gameObjects.add(player);

    }
    @Override
    public void update(GameComponent c, float dt) {
        for(GameObject object: gameObjects){
            object.update(c,dt);
        }
    }

    @Override
    public void render(GameComponent c, Render r) {
        //  c.getRender().drawGrid(c.getWindow().getCanvas().getGraphics(), 16,720,720);
        for(GameObject object: gameObjects){
            object.render(c,r);
        }
    }
    public static void main(String[] args) {

        GameComponent game = new GameComponent(new GameManager());
        game.startGame();
    }
}
