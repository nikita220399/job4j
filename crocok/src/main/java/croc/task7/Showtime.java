package croc.task7;

import java.util.HashSet;
import java.util.Set;

public class Showtime {

    private Set<Seat> seats = new HashSet<>();
    private Set<Seat> buy = new HashSet<>();

    public void addSeats(Seat seat) {
        seats.add(seat);
    }

    public Set<Seat> getFreeSeats() {
        return seats;
    }

    public boolean bookSeat(Seat seat) {
        boolean flag = false;
        for (Seat place : seats) {
            if (seat.getRow() == place.getRow() && seat.getSeat() == place.getSeat()) {
                flag = true;
                seats.remove(place);
                buy.add(seat);
                break;
            }
        }
        return flag;
    }
}
