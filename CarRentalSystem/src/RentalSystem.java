import java.util.Date;
import java.util.List;

public class RentalSystem {
    StoreManager storeManager;
    List<Booking> listOfBookings;

    RentalSystem(StoreManager sm){
       this.storeManager = sm;
    }

    public Booking bookVehicle(Vehicle v, Date start, Date end, User user, Store s){
        Booking b = new Booking(1,start,end,v,2000, BookingStatus.Goingon);
        v.updateVehicleStatus(VehicleStatus.Booked);
        return b;
    }

    public void returnVehicle(Booking booking){
        booking.bookingStatus = BookingStatus.complete;
        booking.vehicle.updateVehicleStatus(VehicleStatus.Idle);
    }
}
