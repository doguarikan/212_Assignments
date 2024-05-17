package hotel_reservation_system;
import java.util.ArrayList;

public interface Calculable {
	static public ArrayList<Calculable> calculablelist = new ArrayList<>();
	public double getCost();
}
