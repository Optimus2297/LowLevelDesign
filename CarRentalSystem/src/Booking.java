import java.util.Date;

public class Booking {
    int id;
    Date start;
    Date end;
    Vehicle vehicle;
    Store store;
    int totalAmount;
    BookingStatus bookingStatus;

    public Booking(int id, Date start, Date end, Vehicle vehicle, int totalAmount, BookingStatus bookingStatus) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.vehicle = vehicle;
        this.totalAmount = totalAmount;
        this.bookingStatus = bookingStatus;
    }
}
