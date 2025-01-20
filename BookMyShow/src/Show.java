import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Show {
    private int id;
    private Movie movie;
    private Theater theater;
    private Date startTime;
    private List<Seat> seats;

    public Show(int id, Movie movie, Theater theater, Date startTime, int totalSeats) {
        this.id = id;
        this.movie = movie;
        this.theater = theater;
        this.startTime = startTime;
        this.seats = new ArrayList<>();

        // Initialize seats
        for (int i = 0; i < totalSeats; i++) {
            seats.add(new Seat(i + 1));
        }
    }

    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public Date getStartTime() {
        return startTime;
    }
}
