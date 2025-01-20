import java.util.ArrayList;
import java.util.List;

public class Theater {
    private int id;
    private String name;
    private String location;
    private List<Show> shows = new ArrayList<>();

    public Theater(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    public List<Show> getShows() {
        return shows;
    }

    public String getLocation() {
        return location;
    }
}

