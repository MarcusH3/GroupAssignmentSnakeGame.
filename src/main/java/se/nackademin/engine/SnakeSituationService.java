package se.nackademin.engine;

public interface SnakeSituationService {

    SnakeSituation moveUp(SnakeSituation situation);
    SnakeSituation moveDown();
    SnakeSituation moveLeft();
    SnakeSituation moveRight();
}
