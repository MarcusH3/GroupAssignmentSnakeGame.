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

        assertTrue(snack.size() == 1);
        assertTrue(makeList(16).contains(snack.get(0).y));
        assertNotEquals(snakeSituation.getFeed(), snakeSituation.getSnake().get(0));
        assertTrue(snakeSituation.getStatus().equals(SnackStatus.LIVE));
    }

    @Test
    void should_return_correct_SnakeSituation_in_move_up_when_snake_stared() {
        Point feed = new Point(2,2);
        Point snakePoint = new Point(2,3);

        SnakeSituation snakeSituation = new SnakeSituation(snakePoint ,feed, SnackStatus.LIVE);


        SnakeSituation actual = sut.moveUp(snakeSituation);

        assertTrue(actual.getSnake().size()==2);
        System.out.println(actual.getFeed());
        assertFalse(actual.getFeed().equals(feed));


    }

    private List<Integer> makeList(int lastIndex) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < lastIndex; i++) {
            integers.add(i);
        }
        return integers;
    }
}