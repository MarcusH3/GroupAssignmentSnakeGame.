package se.nackademin.engine;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class SnakeSituationServiceImpl implements SnakeSituationService {
    final static int X_AREA = 16;
    final static int Y_AREA = 16;


    @Override
    public SnakeSituation moveUp(SnakeSituation situation) {
        List<Point> snake = situation.getSnake();

        if (snake.size() > 0) {
            Point snakeHead = snake.get(snake.size() - 1);
            int newY = snakeHead.y - 1;
            if (newY < 0) {
                situation.setStatus(SnackStatus.DEAD);
            }
            Point newHead = new Point(snakeHead.x, newY);

            if (newHead.equals(situation.getFeed())) {
                snake.add(newHead);
                situation.setFeed(AreaUtils.getRandomPoint(snake));
            } else {
                snake.remove(0);
                snake.add(newHead);
            }
            situation.setSnake(snake);
        }else {
            Point head = snake.get(0);
            Point feed = situation.getFeed();
            if (head.equals(feed)){
                snake.add(feed);
                situation.setFeed(AreaUtils.getRandomPoint(snake));
            }else {
                int newY = head.y - 1;
                head.move(head.x, newY);
                if (newY < 0) {
                    situation.setStatus(SnackStatus.DEAD);
                }
            }
        }
        return situation;
    }

    @Override
    public SnakeSituation moveDown() {
        return null;
    }

    @Override
    public SnakeSituation moveLeft() {
        return null;
    }

    @Override
    public SnakeSituation moveRight() {
        return null;
    }


    private List<Point> initialSnake() {
        List<Point> newSnake = new LinkedList<>();
        newSnake.add(AreaUtils.getRandomPoint());
        return newSnake;
    }
}
