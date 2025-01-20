import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class BookingDemo {
    public static void main(String[] args) throws Exception {
        // Create movies
        Movie inception = new Movie(1, "Inception", "Sci-Fi", 120);
        Movie avatar = new Movie(2, "Avatar", "Action", 150);

        // Create theaters and shows
        Theater theater1 = new Theater(1, "PVR", "Mumbai");
        Show show1 = new Show(1, inception, theater1, new Date(), 10);
        Show show2 = new Show(2, avatar, theater1, new Date(), 15);

        theater1.addShow(show1);
        theater1.addShow(show2);

        // Add theaters to BookingService
        BookingController service = new BookingController();
        service.addTheater(theater1);

        // Search for shows
        System.out.println("Searching for Inception shows in Mumbai:");
        List<Show> shows = service.searchShows("Inception", "Mumbai", new Date());
        for (Show show : shows) {
            System.out.println("Show ID: " + show.getId() + ", Theater: " + show.getTheater().getLocation());
        }

        // Check seat availability
        System.out.println("\nAvailable seats for Show ID 1:");
        List<Seat> availableSeats = service.getAvailableSeats(show1);
        for (Seat seat : availableSeats) {
            System.out.print(seat.getSeatNumber() + " ");
        }

        // Book seats
        User user = new User(1, "John Doe", "john@example.com");
        System.out.println("\n\nBooking seats 1, 2 for Show ID 1...");
        Booking booking = service.bookSeats(user, show1, Arrays.asList(1, 2));
        System.out.println("Booking ID: " + booking.getId());

        // Check availability again
        System.out.println("\nAvailable seats after booking:");
        availableSeats = service.getAvailableSeats(show1);
        for (Seat seat : availableSeats) {
            System.out.print(seat.getSeatNumber() + " ");
        }
    }
}