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
    void should_create_correct_value_when_game_started() {
        SnakeSituation snakeSituation = new SnakeSituation();
        List<Point> snack = snakeSituation.getSnake();

        assertEquals(1, snack.size());
        assertTrue(makeList(15).contains(snack.get(0).x));
        assertTrue(makeList(15).contains(snack.get(0).y));

        assertNotEquals(snakeSituation.getFood(), snakeSituation.getSnake().get(0));
        assertEquals(snakeSituation.getStatus(), SnackStatus.LIVE);
    }

    /* Testing moveLeft method */
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

    /* Testing moveRight method */
    @Test
    void should_MOVERIGHT_make_the_new_snake_bigger_when_food_exist_in_the_right_side() {
        Point food = new Point(2, 2);
        Point snakePoint = new Point(2, 1);

        SnakeSituation snakeSituation = new SnakeSituation(snakePoint, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveRight(snakeSituation);

        assertEquals(2, actual.getSnake().size());
        System.out.println(actual.getFood());
        assertNotEquals(actual.getFood(), food);
    }

    @Test
    void should_MOVERIGHT_doesnt_make_the_new_snake_bigger_when_food_not_exist_in_the_right_side() {
        Point food = new Point(12, 2);
        Point snakePoint = new Point(2, 3);

        SnakeSituation snakeSituation = new SnakeSituation(snakePoint, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveRight(snakeSituation);

        assertEquals(1, actual.getSnake().size());
        System.out.println(actual.getFood());
        assertEquals(actual.getFood(), food);
    }

    @Test
    void should_MOVERIGHT_make_the_existed_snake_bigger_when_food_exist_in_the_left_side() {
        Point food = new Point(6, 9);
        List<Point> snake = new LinkedList<>();
        snake.add(new Point(5, 7));
        snake.add(new Point(5, 8));
        snake.add(new Point(6, 8));

        SnakeSituation snakeSituation = new SnakeSituation(snake, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveRight(snakeSituation);
        List<Point> actualSnake = actual.getSnake();
        Point actualHead = actualSnake.get(actualSnake.size() - 1);
        Point actualTail = actualSnake.get(0);

        assertEquals(4, actual.getSnake().size());
        System.out.println(actual.getFood());
        assertNotEquals(actual.getFood(), food);
        assertTrue(actualHead.x == 6 && actualHead.y == 9);
        assertTrue(actualTail.x == 5 && actualTail.y == 7);
    }

    @Test
    void should_MOVERIGHT_does_not_make_the_existed_snake_bigger_when_food_does_not_exist_in_the_right_side() {
        Point food = new Point(15, 6);
        List<Point> snake = new LinkedList<>();
        snake.add(new Point(7, 11));
        snake.add(new Point(6, 11));
        snake.add(new Point(5, 11));
        snake.add(new Point(5,10 ));
        snake.add(new Point(5,9 ));
        snake.add(new Point(6,9 ));
        snake.add(new Point(7,9 ));
        snake.add(new Point(7,10 ));

        SnakeSituation snakeSituation = new SnakeSituation(snake, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveRight(snakeSituation);
        List<Point> actualSnake = actual.getSnake();
        Point actualHead = actualSnake.get(actualSnake.size() - 1);
        Point actualTail = actualSnake.get(0);

        assertEquals(8, actual.getSnake().size());
        System.out.println(actual.getFood());
        assertEquals(actual.getFood(), food);
        assertTrue(actualHead.x == 7 && actualHead.y == 11);
        assertTrue(actualTail.x == 6 && actualTail.y == 11);
    }

    @Test
    void should_get_SnackStatus_DEAD_when_MOVERIGHT_broke_the_wall() {
        Point food = new Point(15, 6);
        List<Point> snake = new LinkedList<>();
        snake.add(new Point(2, 14));
        snake.add(new Point(2, 15));

        SnakeSituation snakeSituation = new SnakeSituation(snake, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveRight(snakeSituation);

        assertEquals(SnackStatus.DEAD, actual.getStatus());
    }

    @Test
    void should_get_SnackStatus_DEAD_when_MOVERIGHT_make_snake_eat_itself() {
        Point food = new Point(15, 6);
        List<Point> snake = new LinkedList<>();
        snake.add(new Point(8, 11));
        snake.add(new Point(7, 11));
        snake.add(new Point(6, 11));
        snake.add(new Point(5, 11));
        snake.add(new Point(5,10 ));
        snake.add(new Point(5,9 ));
        snake.add(new Point(6,9 ));
        snake.add(new Point(7,9 ));
        snake.add(new Point(7,10 ));

        SnakeSituation snakeSituation = new SnakeSituation(snake, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveRight(snakeSituation);

        assertEquals(SnackStatus.DEAD, actual.getStatus());
    }

    /* Testing moveDown method */
    @Test
    void should_MOVEDOWN_make_the_new_snake_bigger_when_food_exist_in_the_down_side() {
        Point food = new Point(2, 2);
        Point snakePoint = new Point(1, 2);

        SnakeSituation snakeSituation = new SnakeSituation(snakePoint, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveDown(snakeSituation);

        assertEquals(SnackStatus.LIVE, actual.getStatus());
        assertEquals(2, actual.getSnake().size());
        System.out.println(actual.getFood());
        assertNotEquals(actual.getFood(), food);
    }

    @Test
    void should_MOVEDOWN_doesnt_make_the_new_snake_bigger_when_food_not_exist_in_the_down_side() {
        Point food = new Point(12, 2);
        Point snakePoint = new Point(2, 3);

        SnakeSituation snakeSituation = new SnakeSituation(snakePoint, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveDown(snakeSituation);

        assertEquals(1, actual.getSnake().size());
        System.out.println(actual.getFood());
        assertEquals(actual.getFood(), food);
    }

    @Test
    void should_MOVEDOWN_make_the_existed_snake_bigger_when_food_exist_in_the_down_side() {
        Point food = new Point(6, 9);
        List<Point> snake = new LinkedList<>();
        snake.add(new Point(6, 8));
        snake.add(new Point(5, 8));
        snake.add(new Point(4, 8));
        snake.add(new Point(4, 9));
        snake.add(new Point(5, 9));

        SnakeSituation snakeSituation = new SnakeSituation(snake, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveDown(snakeSituation);
        List<Point> actualSnake = actual.getSnake();
        Point actualHead = actualSnake.get(actualSnake.size() - 1);
        Point actualTail = actualSnake.get(0);

        assertEquals(6, actual.getSnake().size());
        System.out.println(actual.getFood());
        assertNotEquals(actual.getFood(), food);
        assertTrue(actualHead.x == 6 && actualHead.y == 9);
        assertTrue(actualTail.x == 6 && actualTail.y == 8);
    }

    @Test
    void should_MOVEDOWN_does_not_make_the_existed_snake_bigger_when_food_does_not_exist_in_the_down_side() {
        Point food = new Point(15, 6);
        List<Point> snake = new LinkedList<>();
        snake.add(new Point(6,9 ));
        snake.add(new Point(6, 8));
        snake.add(new Point(5, 8));
        snake.add(new Point(4, 8));
        snake.add(new Point(4, 9));
        snake.add(new Point(5, 9));

        SnakeSituation snakeSituation = new SnakeSituation(snake, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveDown(snakeSituation);
        List<Point> actualSnake = actual.getSnake();
        Point actualHead = actualSnake.get(actualSnake.size() - 1);
        Point actualTail = actualSnake.get(0);

        assertEquals(6, actual.getSnake().size());
        System.out.println(actual.getFood());
        assertEquals(actual.getFood(), food);
        assertTrue(actualHead.x == 6 && actualHead.y == 9);
        assertTrue(actualTail.x == 6 && actualTail.y == 8);
    }

    @Test
    void should_get_SnackStatus_DEAD_when_MOVEDOWN_broke_the_wall() {
        Point food = new Point(1, 6);
        List<Point> snake = new LinkedList<>();
        snake.add(new Point(14, 10));
        snake.add(new Point(15, 10));

        SnakeSituation snakeSituation = new SnakeSituation(snake, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveDown(snakeSituation);

        assertEquals(SnackStatus.DEAD, actual.getStatus());
    }

    @Test
    void should_get_SnackStatus_DEAD_when_MOVEDOWN_make_snake_eat_itself() {
        Point food = new Point(15, 6);
        List<Point> snake = new LinkedList<>();
        snake.add(new Point(6,10 ));
        snake.add(new Point(6,9 ));
        snake.add(new Point(6, 8));
        snake.add(new Point(5, 8));
        snake.add(new Point(4, 8));
        snake.add(new Point(4, 9));
        snake.add(new Point(5, 9));

        SnakeSituation snakeSituation = new SnakeSituation(snake, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveDown(snakeSituation);

        assertEquals(SnackStatus.DEAD, actual.getStatus());
    }

    /* Testing moveUp method */
    @Test
    void should_MOVEUP_make_the_new_snake_bigger_when_food_exist_in_the_up_side() {
        Point food = new Point(2, 2);
        Point snakePoint = new Point(3, 2);

        SnakeSituation snakeSituation = new SnakeSituation(snakePoint, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveUp(snakeSituation);

        assertEquals(SnackStatus.LIVE, actual.getStatus());
        assertEquals(2, actual.getSnake().size());
        System.out.println(actual.getFood());
        assertNotEquals(actual.getFood(), food);
    }

    @Test
    void should_MOVEUP_doesnt_make_the_new_snake_bigger_when_food_not_exist_in_the_up_side() {
        Point food = new Point(12, 2);
        Point snakePoint = new Point(2, 3);

        SnakeSituation snakeSituation = new SnakeSituation(snakePoint, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveUp(snakeSituation);

        assertEquals(1, actual.getSnake().size());
        assertEquals(SnackStatus.LIVE, actual.getStatus());
        System.out.println(actual.getFood());
        assertEquals(actual.getFood(), food);
    }

    @Test
    void should_MOVEUP_make_the_existed_snake_bigger_when_food_exist_in_the_up_side() {
        Point food = new Point(6, 9);
        List<Point> snake = new LinkedList<>();
        snake.add(new Point(6, 8));
        snake.add(new Point(7, 8));
        snake.add(new Point(8, 8));
        snake.add(new Point(8, 9));
        snake.add(new Point(7, 9));

        SnakeSituation snakeSituation = new SnakeSituation(snake, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveUp(snakeSituation);
        List<Point> actualSnake = actual.getSnake();
        Point actualHead = actualSnake.get(actualSnake.size() - 1);
        Point actualTail = actualSnake.get(0);

        assertEquals(6, actual.getSnake().size());
        System.out.println(actual.getFood());
        assertNotEquals(actual.getFood(), food);
        assertTrue(actualHead.x == 6 && actualHead.y == 9);
        assertTrue(actualTail.x == 6 && actualTail.y == 8);
    }

    @Test
    void should_MOVEUP_does_not_make_the_existed_snake_bigger_when_food_does_not_exist_in_the_down_side() {
        Point food = new Point(15, 6);
        List<Point> snake = new LinkedList<>();
        snake.add(new Point(4, 9));
        snake.add(new Point(3, 9));
        snake.add(new Point(3, 8));
        snake.add(new Point(4, 8));
        snake.add(new Point(5, 8));
        snake.add(new Point(6, 8));
        snake.add(new Point(6, 9));
        snake.add(new Point(5, 9));

        SnakeSituation snakeSituation = new SnakeSituation(snake, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveUp(snakeSituation);
        List<Point> actualSnake = actual.getSnake();
        Point actualHead = actualSnake.get(actualSnake.size() - 1);
        Point actualTail = actualSnake.get(0);

        assertEquals(8, actual.getSnake().size());
        assertEquals(SnackStatus.LIVE, actual.getStatus());
        System.out.println(actual.getFood());
        assertEquals(actual.getFood(), food);
        assertTrue(actualHead.x == 4 && actualHead.y == 9);
        assertTrue(actualTail.x == 3 && actualTail.y == 9);
    }

    @Test
    void should_get_SnackStatus_DEAD_when_MOVEUP_broke_the_wall() {
        Point food = new Point(1, 6);
        List<Point> snake = new LinkedList<>();
        snake.add(new Point(1, 10));
        snake.add(new Point(0, 10));

        SnakeSituation snakeSituation = new SnakeSituation(snake, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveUp(snakeSituation);

        assertEquals(SnackStatus.DEAD, actual.getStatus());
    }

    @Test
    void should_get_SnackStatus_DEAD_when_MOVEUP_make_snake_eat_itself() {
        Point food = new Point(15, 6);
        List<Point> snake = new LinkedList<>();
        snake.add(new Point(4, 10));
        snake.add(new Point(4, 9));
        snake.add(new Point(3, 9));
        snake.add(new Point(3, 8));
        snake.add(new Point(4, 8));
        snake.add(new Point(5, 8));
        snake.add(new Point(6, 8));
        snake.add(new Point(6, 9));
        snake.add(new Point(5, 9));

        SnakeSituation snakeSituation = new SnakeSituation(snake, food, SnackStatus.LIVE);

        SnakeSituation actual = sut.moveUp(snakeSituation);

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