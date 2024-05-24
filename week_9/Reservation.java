package hotel_reservation_system;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.InputMismatchException;

public class Reservation extends Services implements Calculable, Comparable<Reservation>{
	private String hotelName;
	private String reservationMonth;
	private String reservationcity;
	private int reservationStart;
	private int reservationEnd;	
	private static int totalNum = 0;
	

	public Reservation(String hotel_name, String city, String month, int resStart, int resEnd) {		
		this.hotelName = hotel_name;
		this.reservationcity = city;
		this.reservationMonth = month;
		this.reservationEnd = resEnd;
		this.reservationStart = resStart;
		totalNum++;
		setCustomerID(totalNum);
	}

	////////////////////////////////////////////////////////////////////	
	
	public String getHotelName() {
		return hotelName;
		
	}

	public String getReservationMonth() {
		return reservationMonth;
	}

	public int getReservationStart() {
		return reservationStart;
	}

	public int getReservationEnd() {
		return reservationEnd;
	}
	
	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	
	
	////////////////////////////////////////////////////////////////////
	public String display_info() {
		return "Reservation ID #" + getCustomerID() + "\n" + "Reservation at " + getHotelName() + " starts on " + getReservationMonth() + " " + 
				getReservationStart() + " and ends on " + getReservationMonth() + " " + getReservationEnd();
	}
	
	
	////////////////////////////////////////////////////////////////////

	public static int calculate_total_price(int reservation_start, int reservation_end, int daily_cost) {
		return(daily_cost*(reservation_end-reservation_start));
	}
	
	public static int calculate_total_price(int reservation_start, int reservation_end, int daily_cost, int multiplier) {
		return(multiplier * daily_cost*(reservation_end-reservation_start));
	}
	
	
	////////////////////////////////////////////////////////////////////
	
	@Override
	public String getServiceType() {
		return "Room Booking";
	}
	
	///////////////////////////////////////////////////////////////////
	
	@Override
	public int compareTo(Reservation o) {
		return this.getHotelName().compareToIgnoreCase(o.getHotelName());
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculateService() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}