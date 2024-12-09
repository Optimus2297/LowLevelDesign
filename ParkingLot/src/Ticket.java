import java.time.LocalDateTime;

public class Ticket {
    private LocalDateTime entryTime;
    private int ticketID;
    private ParkingSpot p;

    public Ticket(LocalDateTime entryTime, int ticketID, ParkingSpot p) {
        this.entryTime = entryTime;
        this.ticketID = ticketID;
        this.p = p;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public ParkingSpot getP() {
        return p;
    }

    public void setP(ParkingSpot p) {
        this.p = p;
    }
}
