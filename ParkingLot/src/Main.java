import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ParkingSpotManager manager = new ParkingSpotManager();


        Vehicle v1 = new Vehicle("two");
        Vehicle v2 = new Vehicle("two");
        Vehicle v3 = new Vehicle("four");
        Vehicle v4 = new Vehicle("four");

        Ticket t1 = manager.parkVehicle(v1);
        Ticket t2 = manager.parkVehicle(v2);
        Ticket t3 = manager.parkVehicle(v3);
        Ticket t4 = manager.parkVehicle(v4);

        Ticket t = new Ticket(LocalDateTime.now(), 10, new ParkingSpot(1,20));
        manager.vacateVehicle(t);

        int billv1 = manager.vacateVehicle(t1);
        System.out.println("The genertaed bill for vehicle v1 is " + billv1);

        int billv2 = manager.vacateVehicle(t3);
        System.out.println("The genertaed bill for vehicle v3 is " + billv2);
    }
}