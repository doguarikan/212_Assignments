package hotel_reservation_system;

public class Reservation {
	private String hotelName;
	private String reservationMonth;
	private int reservationStart;
	private int reservationEnd;
	private int dailyCost;
	private RoomType roomType;
	
	enum RoomType{
		Single,
		Double,
		Club,
		Family,
		Familywithview,
		Suite
	}
	
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

	public int getDailyCost() {
		return dailyCost;
	}
	
	public RoomType getRoomType() {
		return roomType;
	}

	public Reservation(String hotelName, String reservationMonth, int reservationStart, int reservationEnd, int dailyCost, RoomType roomType) {
		this.hotelName = hotelName;
		this.reservationMonth = reservationMonth;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.dailyCost = dailyCost;
		this.roomType = roomType;
	}
	
	public int calculateTotalPrice(int dailyCost, int reservationStart, int reservationEnd) {
		int cost = 0;
		cost = dailyCost*(reservationEnd-reservationStart);
		
		return cost;
	}
}