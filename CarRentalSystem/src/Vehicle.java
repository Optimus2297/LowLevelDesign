public class Vehicle {
    int id;
    String type;
    int mileage;
    VehicleStatus status;

    public Vehicle(int id, String type, int mileage, VehicleStatus status) {
        this.id = id;
        this.type = type;
        this.mileage = mileage;
        this.status = status;
    }

    public void updateVehicleStatus(VehicleStatus status){
        this.status = status;
    }
}
