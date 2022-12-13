package Game;

import GameObject.GameObject;
import Window.Render;

import java.util.ArrayList;
import java.util.List;

public class GameManager extends AbstractGame{

    private List<GameObject> gameObjects = new ArrayList<>();

    public GameManager() {
        //Vad man vill lägga in..

    }
    @Override
    public void update(GameComponent gameComponent, float dt) {

    }

    @Override
    public void render(GameComponent c, Render r) {
        for(GameObject object: gameObjects){
            render(c,r);
        }
    }
    public static void main(String[] args) {

        GameComponent game = new GameComponent(new GameManager());
        game.startGame();
    }
}
