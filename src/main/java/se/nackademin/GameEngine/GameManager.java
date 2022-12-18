package se.nackademin.GameEngine;
import se.nackademin.GameObject.GameObject;
import se.nackademin.MenuObject.GameOverScreen;
import se.nackademin.MenuObject.TitleScreen;
import se.nackademin.MenuObject.MenuObject;
import se.nackademin.Window.Render;
import se.nackademin.GameObject.Player;
import java.util.ArrayList;
import java.util.List;

public class GameManager extends AbstractGame{

    private final List<GameObject> gameObjects = new ArrayList<>();
    private final List<MenuObject> titleScreen = new ArrayList<>();
    private final List<MenuObject> gameOverScreen = new ArrayList<>();

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
            for (MenuObject object : titleScreen) {
                object.update(c, dt);
            }
        }
        else if(c.getGameState() == GameState.GAME){
            for (GameObject object : gameObjects) {
                object.update(c, dt);
            }
        }
        else if(c.getGameState() == GameState.GAME_OVER){
            for(MenuObject object: gameOverScreen){
                object.update(c, dt);
            }
        }
    }
    @Override
    public void render(GameComponent c, Render r) {
        if(c.getGameState() == GameState.TITLE_SCREEN) {
            for (MenuObject object : titleScreen) {
                object.render(c, r);
            }
        }
        else if (c.getGameState() == GameState.GAME){
            for(GameObject object: gameObjects){
                object.render(c,r);
            }
        } else if(c.getGameState() == GameState.GAME_OVER) {
            for(MenuObject object: gameOverScreen){
                object.render(c,r);
            }
        }
    }
    public static void main(String[] args) {
        GameComponent game = new GameComponent(new GameManager());
        game.startGame();
    }
}