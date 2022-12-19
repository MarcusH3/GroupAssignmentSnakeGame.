package se.nackademin.GameEngine;
import se.nackademin.GameObject.GameObject;
import se.nackademin.GameObject.GameOverScreen;
import se.nackademin.GameObject.TitleScreen;
import se.nackademin.Window.Render;
import se.nackademin.GameObject.Player;
import java.util.ArrayList;
import java.util.List;

public class GameManager extends AbstractGame{

    private final List<GameObject> gameObjects = new ArrayList<>();
    private final List<GameObject> titleScreen = new ArrayList<>();
    private final List<GameObject> gameOverScreen = new ArrayList<>();

    public GameManager() {
        TitleScreen menu = new TitleScreen();
        GameOverScreen gameOver = new GameOverScreen();
        titleScreen.add(menu);
        Player player = new Player(0,0);
        gameObjects.add(player);
        gameOverScreen.add(gameOver);
    }
    @Override
    public void update(GameComponent c, float dt) {
        if(c.getGameState() == GameState.TITLE_SCREEN) {
            for (GameObject object : titleScreen) {
                object.update(c, dt);
            }
        }
        else if(c.getGameState() == GameState.GAME){
            for (GameObject object : gameObjects) {
                object.update(c, dt);
            }
        }
        else if(c.getGameState() == GameState.GAME_OVER){
            for(GameObject object: gameOverScreen){
                object.update(c, dt);
            }
        }
    }
    @Override
    public void render(GameComponent c, Render r) {
        if(c.getGameState() == GameState.TITLE_SCREEN) {
            for (GameObject object : titleScreen) {
                object.render(c, r);
            }
        }
        else if (c.getGameState() == GameState.GAME){
            for(GameObject object: gameObjects){
                object.render(c,r);
            }
        } else if(c.getGameState() == GameState.GAME_OVER) {
            for(GameObject object: gameOverScreen){
                object.render(c,r);
            }
        }
    }
    public static void main(String[] args) {
        GameComponent game = new GameComponent(new GameManager());
        game.startGame();
    }
}