package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.OccupiedWayException;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    //deltaX != (dest.x + 1) && deltaY != (dest.y - 1) &&
    public Cell[] way(Cell source, Cell dest, Figure[] figures) {
        Cell[] steps;
        if (Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y)) {
            int size = Math.abs(source.x - dest.x);
            steps = new Cell[size];
            int deltaX = source.x;
            int deltaY = source.y;
            if (dest.y < source.y && dest.x > source.x) {
                boolean flag = true;
                for (int i = 0; i < size; i++, deltaX++, deltaY--) {
                    for (Cell s : Cell.values()) {
                        if (s.x == deltaX && s.y == deltaY) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag == false) {
                        steps = new Cell[] { source };
                        break;
                    }
                }
                if (flag == true) {
                    steps = new Cell[] { dest };
                }
            }
        } else {
            steps = new Cell[] { source };
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}