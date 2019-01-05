package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KingBlack implements Figure {
    private final Cell position;

    public KingBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest, Figure[] figures) {
        Cell[] steps = new Cell[0];
        if (Math.abs(source.x - dest.x) <= 1 && Math.abs(source.y - dest.y) <= 1) {
            steps = new Cell[] { dest };
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingBlack(dest);
    }
}