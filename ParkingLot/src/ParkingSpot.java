public class ParkingSpot {
    private int parkingId;
    private int price;
    private boolean isAvailable;

    public ParkingSpot(int parkingId, int price) {
        this.parkingId = parkingId;
        this.price = price;
        this.isAvailable = true;
    }

    public int getParkingId() {
        return parkingId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getPrice() {
        return price;
    }
}
