package se.nackademin.engine;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SnakeSituationServiceImplTest {

    SnakeSituationService sut = new SnakeSituationServiceImpl();

    @RepeatedTest(100)
    void testing_Random_functionality() {
        Random r = new Random();
        int i = r.nextInt(0, 16);
        System.out.println(i);
    }

    @RepeatedTest(100)
    void should_create_correct_value_when_game_started() {
        SnakeSituation snakeSituation = new SnakeSituation();
        List<Point> snack = snakeSituation.getSnake();

        assertEquals(1, snack.size());
        assertTrue(makeList(15).contains(snack.get(0).x));
        assertTrue(makeList(15).contains(snack.get(0).y));

        assertNotEquals(snakeSituation.getFood(), snakeSituation.getSnake().get(0));
        assertEquals(snakeSituation.getStatus(), SnackStatus.LIVE);
    }

    @Test
    void should_MOVELEFT_make_the_new_snake_bigger_when_food_exist_in_the_left_side() {
        Point food = new Point(2, 2);
        Point snakePoint = new Point(2, 3);

        SnakeSituation snakeSituation = new SnakeSituation(snakePoint, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveLeft(snakeSituation);

        assertEquals(2, actual.getSnake().size());
        System.out.println(actual.getFood());
        assertNotEquals(actual.getFood(), food);
    }

    @Test
    void should_MOVELEFT_doesnt_make_the_new_snake_bigger_when_food_not_exist_in_the_left_side() {
        Point food = new Point(12, 2);
        Point snakePoint = new Point(2, 3);

        SnakeSituation snakeSituation = new SnakeSituation(snakePoint, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveLeft(snakeSituation);

        assertEquals(1, actual.getSnake().size());
        System.out.println(actual.getFood());
        assertEquals(actual.getFood(), food);
    }

    @Test
    void should_MOVELEFT_make_the_existed_snake_bigger_when_food_exist_in_the_left_side() {
        Point food = new Point(5, 6);
        List<Point> snake = new LinkedList<>();
        snake.add(new Point(6, 8));
        snake.add(new Point(5, 8));
        snake.add(new Point(5, 7));

        SnakeSituation snakeSituation = new SnakeSituation(snake, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveLeft(snakeSituation);

        assertEquals(4, actual.getSnake().size());
        System.out.println(actual.getFood());
        assertNotEquals(actual.getFood(), food);
    }

    @Test
    void should_MOVELEFT_does_not_make_the_existed_snake_bigger_when_food_does_not_exist_in_the_left_side() {
        Point food = new Point(15, 6);
        List<Point> snake = new LinkedList<>();
        snake.add(new Point(6, 8));
        snake.add(new Point(5, 8));
        snake.add(new Point(5, 7));

        SnakeSituation snakeSituation = new SnakeSituation(snake, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveLeft(snakeSituation);
        List<Point> actualSnake = actual.getSnake();
        Point actualHead = actualSnake.get(actualSnake.size() - 1);
        Point actualTail = actualSnake.get(0);

        assertEquals(3, actual.getSnake().size());
        System.out.println(actual.getFood());
        assertEquals(actual.getFood(), food);
        assertTrue(actualHead.x == 5 && actualHead.y == 6);
        assertTrue(actualTail.x == 5 && actualTail.y == 8);
    }

    @Test
    void should_get_SnackStatus_DEAD_when_MOVELEFT_broke_the_wall() {
        Point food = new Point(15, 6);
        List<Point> snake = new LinkedList<>();
        snake.add(new Point(2, 1));
        snake.add(new Point(2, 0));

        SnakeSituation snakeSituation = new SnakeSituation(snake, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveLeft(snakeSituation);

        assertEquals(SnackStatus.DEAD, actual.getStatus());
    }

    @Test
    void should_get_SnackStatus_DEAD_when_MOVELEFT_make_snake_eat_itself() {
        Point food = new Point(15, 6);
        List<Point> snake = new LinkedList<>();
        snake.add(new Point(7, 5));
        snake.add(new Point(6, 5));
        snake.add(new Point(5, 5));
        snake.add(new Point(5, 6));
        snake.add(new Point(6, 6));

        SnakeSituation snakeSituation = new SnakeSituation(snake, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveLeft(snakeSituation);

        assertEquals(SnackStatus.DEAD, actual.getStatus());
    }


    private List<Integer> makeList(int lastIndex) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i <= lastIndex; i++) {
            integers.add(i);
        }
        return integers;
    }
}