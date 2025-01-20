import java.util.List;

public class Booking {
    private int id;
    private User user;
    private Show show;
    private List<Seat> bookedSeats;

    public Booking(int id, User user, Show show, List<Seat> bookedSeats) {
        this.id = id;
        this.user = user;
        this.show = show;
        this.bookedSeats = bookedSeats;
    }

    public int getId() {
        return id;
    }
}