package se.nackademin.engine;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class SnakeSituation {
    private List<Point> snake;
    private Point food;
    private SnackStatus status;

    public SnakeSituation() {
        snake = initialSnake();
        status = SnackStatus.LIVE;
        food = AreaUtils.getRandomPoint(snake.get(0));
    }

    public SnakeSituation(Point snakePoint, Point food, SnackStatus status) {
        this.snake = initialSnakeWith(snakePoint);
        this.food = food;
        this.status = status;
    }
    public SnakeSituation(List<Point> snake, Point food, SnackStatus status) {
        this.snake = snake;
        this.food = food;
        this.status = status;
    }
    public List<Point> getSnake() {
        return snake;
    }

    public void setSnake(List<Point> snake) {
        this.snake = snake;
    }

    public Point getFood() {
        return food;
    }

    public void setFood(Point food) {
        this.food = food;
    }

    public SnackStatus getStatus() {
        return status;
    }

    public void setStatus(SnackStatus status) {
        this.status = status;
    }

    private List<Point> initialSnake() {
        List<Point> newSnake = new LinkedList<>();
        newSnake.add(AreaUtils.getRandomPoint());
        return newSnake;
    }

    private List<Point> initialSnakeWith(Point newPoint) {
        List<Point> newSnake = new LinkedList<>();
        newSnake.add(newPoint);
        return newSnake;
    }
}
