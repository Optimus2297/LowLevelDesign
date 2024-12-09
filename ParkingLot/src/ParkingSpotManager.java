import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingSpotManager {
    private List<ParkingSpot> twoWheelerParkingSpotList;
    private List<ParkingSpot> fourWheelerParkingSpotList;
    private Map<Integer, Ticket> isActive;

    public ParkingSpotManager() {
        ParkingSpotFactory factory = new ParkingSpotFactory();
        this.twoWheelerParkingSpotList = new ArrayList<>();
        this.fourWheelerParkingSpotList = new ArrayList<>();
        for(int i=1;i<5;i++){
            this.twoWheelerParkingSpotList.add(factory.getParkingSpotType("Two",i));
        }
        for(int i=1;i<5;i++) {
            this.fourWheelerParkingSpotList.add(factory.getParkingSpotType("Four", i));
        }
        this.isActive = new HashMap<>();
    }

    public Ticket parkVehicle(Vehicle v){
        if(v.getType().equals("two")){
            ParkingSpot p = findParkingSpace(twoWheelerParkingSpotList);
            if(p==null){
                throw new RuntimeException("No Parking spot available");
            }
            p.setAvailable(false);
            Ticket t = new Ticket(LocalDateTime.now(), p.getParkingId(), p);
            isActive.put(t.getTicketID(), t);
            return t;
        }
        else if(v.getType().equals("four")){
            ParkingSpot p = findParkingSpace(fourWheelerParkingSpotList);
            if(p==null){
                throw new RuntimeException("No Parking spot available");
            }
            p.setAvailable(false);
            Ticket t = new Ticket(LocalDateTime.now(), p.getParkingId(), p);
            isActive.put(t.getTicketID(), t);
            return t;
        }
        return null;
    }

    public ParkingSpot findParkingSpace(List<ParkingSpot> listOfSpots){
        for(ParkingSpot spot: listOfSpots){
            if(spot.isAvailable())
                return spot;
        }
        return null;
    }

    public int vacateVehicle(Ticket ticket){
        if(isActive.containsKey(isActive.get(ticket.getTicketID()))){
            ParkingSpot p = ticket.getP();
            p.setAvailable(true);
            isActive.remove(ticket.getTicketID());
            return generateBill(ticket);
        }
       throw new RuntimeException("Invalid Ticket");
    }

    public int generateBill(Ticket ticket){
        LocalDateTime entryTime = ticket.getEntryTime();
        int hours = Math.abs(LocalDateTime.now().getMinute() - entryTime.getMinute());
        return ticket.getP().getPrice() * 5;
    }
}
