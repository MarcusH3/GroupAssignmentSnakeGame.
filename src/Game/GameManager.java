package Game;

import GameObject.GameObject;
import GameObject.Player;
import GameObject.Board;
import Window.Render;

import java.util.ArrayList;
import java.util.List;

public class GameManager extends AbstractGame{

    private List<GameObject> gameObjects = new ArrayList<>();

    public GameManager() {

        Player player = new Player(0,0);
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
        for(GameObject object: gameObjects){
            object.render(c,r);
        }
    }
    public static void main(String[] args) {

        GameComponent game = new GameComponent(new GameManager());
        game.startGame();
    }
}
