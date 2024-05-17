package hotel_reservation_system;

import java.util.Comparator;
import java.lang.Double;

public class CostComparator implements Comparator<Services>{

	@Override
	public int compare(Services o1, Services o2) {
		
		return Double.compare(o2.getCost(), o1.getCost());
	}

}
