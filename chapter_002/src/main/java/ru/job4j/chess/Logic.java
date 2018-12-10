package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.PawnBlack;

import java.util.Optional;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;
    private Figure between;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        boolean flag = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                for (int i = 0; i < this.figures.length; i++) {
                    if (this.figures[i].position().equals(dest)) {
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    rst = true;
                    this.figures[index] = this.figures[index].copy(dest);
                }
            }
        }
        return rst;
    }

//    public boolean occupied(Cell source, Cell dest, Cell[] steps) {
//        boolean flag = true;
//        int dx = Math.abs(source.x - dest.x);
//        int dy = Math.abs(source.y - dest.y);
//        for (int i = 0, index1 = source.x, index2 = source.y; i < this. figures.length && index1 < dx && index2 < dy; i++, index1++, index2++) {
//            this.between
//        }
//        return flag;
//    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    public int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}