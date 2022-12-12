package Game;

public class GameManager extends AbstractGame{

    public GameManager() {
        //Vad man vill lägga in..

    }
    @Override
    public void update(GameComponent gameComponent, float dt) {

    }

    @Override
    public void render() {

    }
    public static void main(String[] args) {

        GameComponent game = new GameComponent(new GameManager());
        game.startGame();
    }
}
