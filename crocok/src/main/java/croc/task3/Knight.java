package croc.task3;

public class Knight {
    private String[] cell;

    public Knight(String[] cell) {
        this.cell = cell;
    }

    public void move() {
        boolean flag = false;
        for (int i = 1, j = 0; i < cell.length; i++, j++) {
            try {
                flag = doing(Point.transfer(cell[j]), Point.transfer(cell[i]));
            } catch (MoveException me) {
                flag = false;
                System.out.println("Конь так не ходит: " + cell[j] + "->" + cell[i]);
                break;
            }
        }
        if (flag == true) {
            System.out.println("OK");
        }
    }

    private boolean doing(Point source, Point dest) throws MoveException{
        boolean flag = false;
        int dx = Math.abs(source.getX() - dest.getX());
        int dy = Math.abs(source.getY() - dest.getY());
        if ((dx == 1 && dy == 2) || (dx == 2 && dy == 1)) {
            return flag = true;
        } else {
            throw new MoveException();
        }
    }
}
