package ru.job4j.chess.firuges;

public class ImpossibleMoveException extends RuntimeException {

    public ImpossibleMoveException(String message) {
        super(message);
    }
}
