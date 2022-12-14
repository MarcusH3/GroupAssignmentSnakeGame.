package se.nackademin.engine;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class AreaUtils {

    //Give a random number between 0-16
    public static Point getRandomPoint() {
        Random r = new Random();
        int x = r.nextInt(0, 16);
        int y = r.nextInt(0, 16);

        return new Point(x, y);
    }

    public static Point getRandomPoint(Point excludePoint) {
        Point randomPoint;
        do {
            randomPoint = getRandomPoint();
        } while (randomPoint.x == excludePoint.x && randomPoint.y == excludePoint.y);

        return randomPoint;
    }

    public static boolean isLocated(Point point ,List<Point> points) {
        for (Point p: points) {
            if (p.x == point.x && p.y == point.y){
                return true;
            }
        }
            return false;
    }

    public static Point getRandomPoint(List<Point> excludePoints) {
        Point randomPoint;
        do {
            randomPoint = getRandomPoint();
        } while (isLocated(randomPoint, excludePoints));

        return randomPoint;
    }

}
