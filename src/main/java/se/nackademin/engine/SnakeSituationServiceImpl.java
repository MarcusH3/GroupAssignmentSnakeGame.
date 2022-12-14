package se.nackademin.engine;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class SnakeSituationServiceImpl implements SnakeSituationService {
    final static int X_AREA = 16;
    final static int Y_AREA = 16;


    @Override
    public SnakeSituation moveUp(SnakeSituation situation) {
        return null;
    }

    @Override
    public SnakeSituation moveDown(SnakeSituation situation) {
        return null;
    }

    @Override
    public SnakeSituation moveLeft(SnakeSituation situation) {
        List<Point> snake = situation.getSnake();
        Point head = snake.get(snake.size() - 1);
        Point food = situation.getFood();

        if (head.x == food.x && (head.y - 1 == food.y)) {
            snake.add(food);
            situation.setSnake(snake);
            situation.setFood(AreaUtils.getRandomPoint(snake));
        } else {
            snake.remove(0);
            int newY = head.y - 1;
            if (newY < 0 || AreaUtils.isLocated(new Point(head.x, newY), snake)) {
                situation.setStatus(SnackStatus.DEAD);
            }
            snake.add(new Point(head.x, newY));
            situation.setSnake(snake);
        }
        return situation;
    }

    @Override
    public SnakeSituation moveRight(SnakeSituation situation) {
        return null;
    }

}
