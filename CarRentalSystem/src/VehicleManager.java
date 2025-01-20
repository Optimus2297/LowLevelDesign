import java.util.ArrayList;
import java.util.List;

public class VehicleManager {
    List<Vehicle> listOfVehicles = new ArrayList<>();

    public void addVehicle(Vehicle v){
        listOfVehicles.add(v);
    }

    public void removeVehicle(Vehicle v){
        listOfVehicles.remove(v);
    }
}
