package se.nackademin.engine;

public interface SnakeSituationService {

    SnakeSituation moveUp(SnakeSituation situation);
    SnakeSituation moveDown(SnakeSituation situation);
    SnakeSituation moveLeft(SnakeSituation situation);
    SnakeSituation moveRight(SnakeSituation situation);
}
