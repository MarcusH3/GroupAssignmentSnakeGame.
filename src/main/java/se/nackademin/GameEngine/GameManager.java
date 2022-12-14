package main.java.se.nackademin.GameEngine;
import main.java.se.nackademin.GameObject.GameObject;
import main.java.se.nackademin.GameObject.Sound;
import main.java.se.nackademin.Window.Render;
import main.java.se.nackademin.GameObject.Player;
import java.util.ArrayList;
import java.util.List;


public class GameManager extends AbstractGame{
    private List<GameObject> gameObjects = new ArrayList<>();
    Sound sound = new Sound();
    public GameManager() {

        Player player = new Player(0,0);
        gameObjects.add(player);       
        playMusic(1);

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
    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    public void stopMusic(){
        sound.stop();
    }
    public void playLvl(int i){
        sound.setFile(i);
        sound.play();
    }
}
