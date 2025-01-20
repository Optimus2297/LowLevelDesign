import java.util.ArrayList;
import java.util.List;

public class StoreManager {
    List<Store> listOfStores = new ArrayList<>();

    public void addStore(Store s){
        listOfStores.add(s);
    }

    public void removeStore(Store s) {
        listOfStores.remove(s);
    }
}
