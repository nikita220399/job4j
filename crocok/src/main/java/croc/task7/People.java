package croc.task7;

public class People implements Runnable{

    private Seat seat;
    private Showtime showtime;
    private static final Object lock = new Object();

    public People(Seat seat, Showtime showtime) {
        this.seat = seat;
        this.showtime = showtime;
    }

    @Override
    public void run() {
        boolean flag;
        synchronized (lock) {
            if (showtime.bookSeat(seat) == true) {
                flag = true;
                System.out.println(flag);
            } else {
                flag = false;
                System.out.println(flag);
            }
        }
    }

    public static void main(String[] args) {
        Showtime showtime = new Showtime();
        showtime.addSeats(new Seat(1, 1));
        showtime.addSeats(new Seat(1, 2));
        showtime.addSeats(new Seat(1, 3));
        showtime.addSeats(new Seat(1, 4));
        People people1 = new People(new Seat(1, 1), showtime);
        People people2 = new People(new Seat(1, 1), showtime);
        Thread t1 = new Thread(people1);
        Thread t2 = new Thread(people2);
        t1.start();
        t2.start();
    }
}
