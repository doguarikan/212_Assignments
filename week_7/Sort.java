package hotel_reservation_system;

import java.util.ArrayList;
import java.util.Collections;

public class Sort {
	
	static ArrayList<Services> servicelist = new ArrayList<>();
	static ArrayList<Reservation> reservationList = new ArrayList<>();
	
	public static void sortServices() {
		for(Calculable calcu : Calculable.calculablelist) {
			if(calcu instanceof Services && !servicelist.contains(calcu))
				servicelist.add((Services) calcu);
		}
		Collections.sort(servicelist,new CostComparator());
		for(Services ser : servicelist)
			ser.displayServiceInfo();
	}
	
	public static void sortReservations() {
		for(Calculable calcu : Calculable.calculablelist) {
			if(calcu instanceof Reservation && !reservationList.contains(calcu))
				reservationList.add((Reservation) calcu);
		}
		
		Collections.sort(reservationList);
		
		for(Reservation res : reservationList) {
			System.out.print("Hotel Name: " + res.getHotelName() + ", "); 
			res.displayServiceInfo();
		}
	}
}
