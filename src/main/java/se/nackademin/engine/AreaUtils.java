package se.nackademin.engine;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class AreaUtils {

    public static Point getRandomPoint() {
        Random r = new Random();
        int x = r.nextInt(0, 16);
        int y = r.nextInt(0, 16);

        return new Point(x, y);
    }

    public static Point getRandomPoint(Point excludePoint) {
        Random r = new Random();
        int x = 0, y = 0;

        do {
            x = r.nextInt(0, 16);
            y = r.nextInt(0, 16);
        } while (x == excludePoint.x && y == excludePoint.y);

        return new Point(x, y);
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
        int x = 0, y = 0;
        Point randomPoint = new Point();

        Random r = new Random();
        do {
            randomPoint.setLocation(r.nextInt(0, 16),r.nextInt(0, 16));
        } while (!isLocated(randomPoint, excludePoints));

        return randomPoint;
    }

}
