import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BookingController {
    private List<Theater> theaters = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    private int bookingIdCounter = 1;

    public void addTheater(Theater theater) {
        theaters.add(theater);
    }

    public List<Show> searchShows(String name, String location, Date date){
        List<Show> result = new ArrayList<>();
        for(Theater theater : theaters){
            if(theater.getLocation().equals(location)){
                for(Show show: theater.getShows()){
                    if(show.getMovie().getTitle().equals(name) && isSameDay(show.getStartTime(), date)){
                        result.add(show);
                    }
                }
            }
        }
        return result;
    }

    public List<Seat> getAvailableSeats(Show show) {
        List<Seat> availableSeats = new ArrayList<>();
        for (Seat seat : show.getSeats()) {
            if (!seat.isBooked()) {
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }

    public Booking bookSeats(User user, Show show, List<Integer> seatNumbers) throws Exception {
        List<Seat> bookedSeats = new ArrayList<>();
        synchronized (show) { // Ensure thread safety
            for (int seatNumber : seatNumbers) {
                Seat seat = show.getSeats().get(seatNumber - 1);
                if (seat.isBooked()) {
                    throw new Exception("Seat " + seatNumber + " is already booked.");
                }
                seat.book();
                bookedSeats.add(seat);
            }
        }
        Booking booking = new Booking(bookingIdCounter++, user, show, bookedSeats);
        bookings.add(booking);
        return booking;
    }


    private boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }
}
