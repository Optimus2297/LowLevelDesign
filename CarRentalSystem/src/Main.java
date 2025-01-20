import java.util.Date;

public class Main {
    public static void main(String[] args) {
        User user = new User(1,"Bhaskar", "pune");
        Vehicle v = new Vehicle(1,"Car", 10, VehicleStatus.Idle);
        Vehicle v2 = new Vehicle(2,"Car", 10, VehicleStatus.Idle);
        VehicleManager vm = new VehicleManager();
        vm.listOfVehicles.add(v);
        vm.listOfVehicles.add(v2);
        Store s = new Store(1,"Pune");
        s.vehicleManager = vm;
        StoreManager sm = new StoreManager();
        sm.addStore(s);
        RentalSystem system = new RentalSystem(sm);
        System.out.println(system.storeManager.listOfStores);

        Booking b = system.bookVehicle(v,new Date(2025,5,24), new Date(2025,5,30), user, s);
        System.out.println("vehicle status: " + v.status + " booking status: " + b.bookingStatus);
        system.returnVehicle(b);
        System.out.println(b.bookingStatus);
    }
}