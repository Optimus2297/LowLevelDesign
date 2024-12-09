public class ParkingSpotFactory{
    public ParkingSpot getParkingSpotType(String type, int id){
        switch(type){
            case "Two" -> {
                return new TwoWheelerParkingSpot(id);
            }
            case "Four" -> {
                return new FourWheelerParkingSpot(id);
            }
        }
        return null;
    }
}
