package se.nackademin.engine;

import lombok.Builder;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

@Builder
public class Position {
    List<Point> snack = new LinkedList<>();
    Point feed;
    SnackStatus snackStatus;

}
